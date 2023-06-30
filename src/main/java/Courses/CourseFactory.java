package Courses;

public class CourseFactory {

    private boolean codeFound = false;
    private boolean unitsFound = false;
    private boolean gradeFound = false;
    private Course course = new Course();

    public boolean isCourseBuilt() { return codeFound && unitsFound && gradeFound; }
    public Course getCourse() {
        Course result = course;
        resetFactory();
        return result;
    }

    public void buildCourse(String line) {
        CodeFinder cFinder = new CodeFinder(line);
        if (cFinder.containsCourse()) {
            if (codeFound) {
                resetFactory();
            }
            course.setCode(cFinder.getCourse());
            codeFound = true;
        }

        UnitFinder uFinder = new UnitFinder(line);
        if (uFinder.containsUnits() && !unitsFound && codeFound) {
            course.setUnits(uFinder.getUnits());
            unitsFound = true;
        }

        GradeFinder gFinder = new GradeFinder();
        if (gFinder.containsGrade(line) && !gradeFound && codeFound) {
            course.setGrade(gFinder.getGrade(line));
            gradeFound = true;
        }
    }

    private void resetFactory() {
        codeFound = false;
        unitsFound = false;
        gradeFound = false;
        course = new Course();
    }

}
