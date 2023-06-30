package PDF;

import Courses.Course;
import Courses.CourseFactory;
import Courses.GradeFinder;

import java.util.ArrayList;
import java.util.List;

public class CourseParser {

    public static List<Course> getAllCourses(String[] transcript) {
        CourseFactory courseFactory = new CourseFactory();
        List<Course> courseList = new ArrayList<>();
        for (String line : transcript) {
            courseFactory.buildCourse(line);
            if (courseFactory.isCourseBuilt()) {
                courseList.add(courseFactory.getCourse());
            }
        }
        return courseList;
    }

    public static List<Course> getGradedCourses(String[] transcript) {
        List<Course> courseList = getAllCourses(transcript);
        List<Course> relevantCourses = new ArrayList<>();
        GradeFinder gFinder = new GradeFinder();
        for (Course c : courseList) {
            if (gFinder.containsLetterGrade(c.getGrade())) {
                relevantCourses.add(c);
            }
        }
        return relevantCourses;
    }
}
