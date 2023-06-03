package Parser;

import Courses.Course;
import Courses.GradeFinder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CourseParser {
    public static List<Course> getAllCourses(String filePath) throws IOException {
        String[] transcript = TextConverter.convertPDFtoTxt(filePath);
        Course course = new Course();
        List<Course> courseList = new ArrayList<>();
        for (int i = 0; i < transcript.length; i++) {
            course.buildCourse(transcript[i]);
            if (course.isBuilt() && course.wasCompleted()) {
                courseList.add(course);
                course = new Course();
            } else if (!course.wasCompleted()) {
                course = new Course();
                i--;
            }
        }
        return courseList;
    }

    public static List<Course> getGradedCourses(String filePath) throws IOException {
        List<Course> courseList = getAllCourses(filePath);
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
