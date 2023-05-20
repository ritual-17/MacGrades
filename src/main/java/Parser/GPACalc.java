package Parser;

import Courses.Course;
import Courses.GradeFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GPACalc {

    boolean courseLog = false;

    public GPACalc() {}

    public GPACalc(boolean courseLog) {
        this.courseLog = courseLog;
    }

    public double getCGPA(String doc) throws IOException {
        String[] result = TextConverter.convertPDFtoTxt(doc);
        Course course = new Course();
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < result.length; i++) {
            course.buildCourse(result[i]);
            if (course.status() && course.isRelevant()) {
                courseList.add(course);
                course = new Course();
            } else if (!course.isRelevant()) {
                course = new Course();
                i--;
            }
        }
        if (courseLog) {
            for (Course c : courseList) {
                System.out.printf("%s: %s, %s units %n", c.getCode(), c.getGrade(), c.getUnits());
            }
        }
        courseList = filterCourses(courseList);
        double pointsEarned = 0;
        double pointsAttm = 0;
        GradeDict gradeDict = new GradeDict();
        for (Course c : courseList) {
            double macGrade = gradeDict.getGrade(c.getGrade());
            double units = Double.parseDouble(c.getUnits());
            pointsEarned += macGrade*units;
            pointsAttm += 12.0*units;
        }

        if (courseLog) {
            System.out.printf("Points Earned: %.1f %n", pointsEarned);
            System.out.printf("Points Attm: %.1f %n", pointsAttm);
        }

        return pointsEarned/pointsAttm*12;
    }

    private List<Course> filterCourses(List<Course> courseList) {
        List<Course> relevantCourses = new ArrayList<>();
        GradeFinder gFinder;
        for (Course c : courseList) {
            gFinder = new GradeFinder(c.getGrade());
            if (gFinder.containsLetterGrade()) {
                relevantCourses.add(c);
            }
        }
        return relevantCourses;
    }

}
