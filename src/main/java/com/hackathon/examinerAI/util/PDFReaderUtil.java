package com.hackathon.examinerAI.util;

import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFReaderUtil {

    public static String readPDF(String filePath) throws IOException {
        File file = new File(filePath);
        PDDocument document = null;
        try {
            document = PDDocument.load(file);
            PDFTextStripper stripper = new PDFTextStripper();
            return stripper.getText(document).strip();
        } finally {
            if (document != null) {
                document.close();
            }
        }
    }
}
