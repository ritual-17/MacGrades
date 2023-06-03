package Courses;

public class Course {
    private String code;
    private String units;
    private String grade;

    private boolean codeFound = false;
    private boolean unitsFound = false;
    private boolean gradeFound = false;
    private boolean completed = true;

    public void buildCourse(String line) {
        CodeFinder cFinder = new CodeFinder(line);
        if (cFinder.containsCourse() && !codeFound) {
            code = cFinder.getCourse();
            codeFound = true;
        } else if (cFinder.containsCourse() && codeFound) {
            completed = false;
            return;
        }

        UnitFinder uFinder = new UnitFinder(line);
        if (uFinder.containsUnits() && !unitsFound && codeFound) {
            units = uFinder.getUnits();
            unitsFound = true;
        }

        GradeFinder gFinder = new GradeFinder(line);
        if (gFinder.containsGrade() && !gradeFound && codeFound) {
            grade = gFinder.getGrade();
            gradeFound = true;
        }

    }
    public String getCode() {
        return code;
    }
    public String getUnits() {
        return units;
    }
    public String getGrade() {
        return grade;
    }

    public boolean isBuilt() {
        return codeFound && unitsFound && gradeFound;
    }

    public boolean wasCompleted() { return completed; }

}
