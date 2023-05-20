package Courses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CodeFinder {
    private final Pattern undergradCoursePattern = Pattern.compile("[A-Z]{3,} [0-9][A-Z0-9]{2}[0-9][A|B]*");

    private Matcher matcher;
    private final String line;
    public CodeFinder(String line) {
        this.line = line;
    }

    public boolean containsCourse() {
        matcher = undergradCoursePattern.matcher(line);
        return matcher.find();
    }

    public String getCourse() {
        return line.substring(matcher.start(), matcher.end());
    }
}
