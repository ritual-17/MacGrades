import Parser.GPACalc;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        GPACalc calculator = new GPACalc(true);
        double cGPA = calculator.getCGPA(args[0]);
        System.out.printf("cGPA: %.1f %n", cGPA);
    }
}
