package com.amk.cucumber.utility;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import lombok.Getter;

public class PDFReader {

    private static final Logger LOG = LoggerFactory.getLogger(DBUtil.class.getName());

    private PDDocument pdfDocument;
    private PDFTextStripper pdfTextStripper;
    @Getter private String pdfText;

    public PDFReader(File pdfFile) {
        try {
            this.pdfDocument = PDDocument.load(pdfFile);
            this.pdfTextStripper = new PDFTextStripper();
            this.pdfText = this.pdfTextStripper.getText(this.pdfDocument);
        } catch (IOException e) {
            LOG.error("Exception occurred while reading pdf. File Path = " + pdfFile.getAbsolutePath());
            LOG.error(e.getMessage());
        }
    }

    /**
     * To check if the given text found in the pdf file
     *
     * @param searchText
     * @return
     */
    public boolean isTextFound(String searchText) {
        return Pattern.compile(Pattern.quote(searchText), Pattern.CASE_INSENSITIVE).matcher(this.pdfText).find();
    }

    /**
     * To close the PDFDocument instance
     */
    public void closePDF() {
        try {
            this.pdfDocument.close();
        } catch (IOException e) {
            LOG.error("Exception occurred while closing pdfDocument");
            LOG.error(e.getMessage());
        }

    }
   
   

    // Test the PDFReader
    public static void main(String[] args) {
        String filePath = "C:\\Users\\Deepti.Nadimpally\\Desktop\\Test\\sample.pdf";
        String searchText = "textToSearch";
        File file = new File(filePath);
        PDFReader pdfReader = new PDFReader(file);
        System.out.println("PDF Text:\n" + pdfReader.pdfText);
        boolean isTextFound = pdfReader.isTextFound(searchText);
        System.out.println("Is Text '" + searchText + "' found = " + isTextFound);
        pdfReader.closePDF();
    }
}
