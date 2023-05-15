package Courses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CourseFinder {

    private static Pattern undergradCoursePattern = Pattern.compile("[A-Z]{3,} [0-9][A-Z0-9]{2}[0-9][A|B]*");
    public static boolean isCourse(String line) {
        Matcher matcher = undergradCoursePattern.matcher(line);
        return matcher.find();
    }

    public static String course(String line) {
        Matcher matcher = undergradCoursePattern.matcher(line);
        matcher.find();
        return line.substring(matcher.start(), matcher.end());
    }
}
