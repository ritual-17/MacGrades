package Courses;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnitFinder {
    private final Pattern scorePattern = Pattern.compile("[0-9]*[.][0]{2}[/][0-9]*[.][0]{2}|[0-9]*[.][0]{2}");
    private Matcher matcher;
    private final String line;
    public UnitFinder(String line) {
        this.line = line;
    }

    public boolean containsUnits() {
        matcher = scorePattern.matcher(line);
        return matcher.find();
    }

    public String getUnits() {
        String units = line.substring(matcher.start(), matcher.end());
        String[] temp = units.split("/");

        return temp[0].strip();
    }
}
