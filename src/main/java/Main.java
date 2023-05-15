import Courses.CourseFinder;
import Parser.TextConverter;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] result = TextConverter.convertPDFtoTxt(args[0]);
        for (String line : result) {
            if (CourseFinder.isCourse(line)) {
                System.out.println(line);
            }
        }
    }
}
