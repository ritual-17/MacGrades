package Parser;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.io.IOUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TextConverter {
    public static String convertPDFtoTxt(String filepath) throws IOException {
        byte[] pdfBytes = pdfBytes(filepath);
        File file = new File(filepath);
        PDDocument pddDoc = Loader.loadPDF(file);
        PDFTextStripper reader = new PDFTextStripper();
        String pageText = reader.getText(pddDoc);
        pddDoc.close();
        return pageText;

    }

    private static byte[] pdfBytes(String filepath) throws IOException {
        FileInputStream inputStream = new FileInputStream(filepath);
        return IOUtils.toByteArray(inputStream);
    }
}
