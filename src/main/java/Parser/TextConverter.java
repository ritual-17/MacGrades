package Parser;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

public class TextConverter {
    public static String[] convertPDFtoTxt(String filepath) throws IOException {
        File file = new File(filepath);
        PDDocument pddDoc = Loader.loadPDF(file);
        PDFTextStripper reader = new PDFTextStripper();
        String pageText = reader.getText(pddDoc);
        pddDoc.close();
        String[] lines = pageText.split("\n");
        return lines;
    }
}
