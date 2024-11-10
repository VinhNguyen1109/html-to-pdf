package com.v17tech.html_to_pdf.service.serviceImpl;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.layout.font.FontProvider;
import com.v17tech.html_to_pdf.service.GeneratePdfService;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class GeneratePdfServiceImpl implements GeneratePdfService {

    private String projectDir = System.getProperty("user.dir");

    //change your input path
   private String htmlFilePath =  projectDir + File.separator +"src\\main\\resources\\templates\\pdf-template-resource.html";

   //change your output path
   private String outputPdfPath = projectDir + File.separator +  "src\\main\\resources\\templates\\pdf-output.pdf";

   //change your font path
   private String fontPath = projectDir + File.separator + "SF Pro Text\\SF-Pro-Text-Black.otf";
    @Override
    public void convertHtmlToPdf() throws IOException {
        System.out.println(fontPath);
        File htmlFile = new File(htmlFilePath);
        if(!htmlFile.exists()){
            throw new IOException("Can not find html file path");
        }
        try {
            InputStream inputStream = new FileInputStream(htmlFile);
            FileOutputStream outputStream = new FileOutputStream(outputPdfPath);

            FontProvider fontProvider = new FontProvider();
            fontProvider.addFont(fontPath);

            HtmlConverter.convertToPdf(inputStream, outputStream);
        }catch (Exception ex){
            throw new IOException("Fail to creat pdf file");
        }
    }
}
