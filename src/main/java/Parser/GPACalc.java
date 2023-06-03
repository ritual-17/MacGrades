package Parser;

import Courses.Course;

import java.util.List;
import java.util.Map;

public class GPACalc {

    public double getCGPA(List<Course> courseList, Map<String, Double> gradeDict) {
        double pointsEarned = 0;
        double pointsAttm = 0;

        for (Course c : courseList) {
            try {
                double grade = gradeDict.get(c.getGrade());
                double units = Double.parseDouble(c.getUnits());
                pointsEarned += grade*units;
                pointsAttm += units;
            } catch (NullPointerException courseNotGraded) {
                continue;
            }
        }

        return pointsEarned/pointsAttm;
    }

}
