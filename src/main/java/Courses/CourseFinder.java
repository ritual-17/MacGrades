package Courses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseFinder {

    private static Pattern undergradCoursePattern = Pattern.compile("[A-Z]{3,} [0-9][A-Z|0]{2}[0-9][A|B]*");
    public static boolean isCourse(String course) {
        Matcher matcher = undergradCoursePattern.matcher(course);
        return matcher.find();
    }
}
