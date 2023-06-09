import Courses.Course;
import PDF.CourseParser;
import GPA.GPACalc;
import GPA.GradeDict;
import PDF.TextConverter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] transcriptLines = TextConverter.convertPDFtoTxt(args[0]);
        List<Course> courseList = CourseParser.getGradedCourses(transcriptLines);
        if (courseList.isEmpty()) {
            System.out.println("No Courses Found");
            return;
        }
        for (Course c : courseList) {
            System.out.printf("%s: %s, %s units %n", c.getCode(), c.getGrade(), c.getUnits());
        }
        GradeDict gradeDict = new GradeDict();
        Map<String, Double> macGradesDict = gradeDict.getMacGradeDict();
        Map<String, Double> standardGradesDict = gradeDict.getStandardGradeDict();
        GPACalc calculator = new GPACalc();
        double macCGPA = calculator.getGPA(courseList, macGradesDict);
        double standardCGPA = calculator.getGPA(courseList, standardGradesDict);
        System.out.printf("McMaster cGPA: %.1f %n", macCGPA);
        System.out.printf("4.0 Scale cGPA: %.2f %n", standardCGPA);
    }
}
