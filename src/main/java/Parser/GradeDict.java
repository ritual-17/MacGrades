package Parser;

import java.util.HashMap;
import java.util.Map;

public class GradeDict {
    private Map<String, Double> grades = new HashMap<>();

    public GradeDict() {
        grades.put("A+", 12.0);
        grades.put("A", 11.0);
        grades.put("A-", 10.0);
        grades.put("B+", 9.0);
        grades.put("B", 8.0);
        grades.put("B-", 7.0);
        grades.put("C+", 6.0);
        grades.put("C", 5.0);
        grades.put("C-", 4.0);
        grades.put("D+", 3.0);
        grades.put("D", 2.0);
        grades.put("D-", 1.0);
        grades.put("F", 0.0);
    }

    public double getGrade(String letterGrade) {
        return grades.get(letterGrade);
    }
}
