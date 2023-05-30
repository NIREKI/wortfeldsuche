package main;

import java.io.File;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        File image = new File("src/FxT-CTKXwAYLgh-.jpg");
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("src/main/resources/tessdata");
        tesseract.setLanguage("deu");
        tesseract.setPageSegMode(1);
        tesseract.setOcrEngineMode(1);
        try {
            String result = tesseract.doOCR(image);
            System.out.println(result);
        } catch (TesseractException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
