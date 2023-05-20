package Courses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GradeFinder {

    private final Pattern letterPattern = Pattern.compile(" [A-D][+|-]?$| F$|^[A-D][+|-]?$|^F$");
    private final Pattern other = Pattern.compile(" AUD$| NC$| P$| MT$| COM$| W$| T$|^AUD$|^NC$|^P$|^MT$|^COM$|^W$|^T$");
    private final String line;
    private Matcher matcher;

    public GradeFinder(String line) { this.line = line; }

    public boolean containsGrade() {
        matcher = letterPattern.matcher(line);
        if (matcher.find()) {
            return true;
        }
        matcher = other.matcher(line);
        return matcher.find();
    }

    public boolean containsLetterGrade() {
        matcher = letterPattern.matcher(line);
        return matcher.find();
    }

    public String getGrade() {
        String grade = line.substring(matcher.start(), matcher.end());
        return grade.strip();
    }


}
