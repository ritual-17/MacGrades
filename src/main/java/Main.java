import Courses.Course;
import Parser.CourseParser;
import Parser.GPACalc;
import Parser.GradeDict;
import Parser.TextConverter;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] transcriptLines = TextConverter.convertPDFtoTxt(args[0]);
        List<Course> courseList = CourseParser.getGradedCourses(transcriptLines);
        for (Course c : courseList) {
            System.out.printf("%s: %s, %s units %n", c.getCode(), c.getGrade(), c.getUnits());
        }
        GradeDict gradeDict = new GradeDict();
        Map<String, Double> macGradesDict = gradeDict.getMacGradeDict();
        Map<String, Double> standardGradesDict = gradeDict.getStandardGradeDict();
        GPACalc calculator = new GPACalc();
        double macCGPA = calculator.getCGPA(courseList, macGradesDict);
        double standardCGPA = calculator.getCGPA(courseList, standardGradesDict);
        System.out.printf("McMaster cGPA: %.1f %n", macCGPA);
        System.out.printf("4.0 Scale cGPA: %.2f %n", standardCGPA);
    }
}
