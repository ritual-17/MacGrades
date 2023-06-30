package Parser;

import Courses.Course;
import Courses.GradeFinder;

import java.util.ArrayList;
import java.util.List;

public class CourseParser {

    public static List<Course> getAllCourses(String[] transcript) {
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
