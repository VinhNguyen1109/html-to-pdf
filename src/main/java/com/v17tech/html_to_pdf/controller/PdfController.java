package com.v17tech.html_to_pdf.controller;

import com.v17tech.html_to_pdf.service.GeneratePdfService;
import com.v17tech.html_to_pdf.service.serviceImpl.GeneratePdfServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pdf")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PdfController {
    private static final Logger logger = LoggerFactory.getLogger(PdfController.class);
    private final GeneratePdfService pdfService;

    @PostMapping("/generate")
    public ResponseEntity<?> generatePdf(){
        try {
            pdfService.convertHtmlToPdf();
            return ResponseEntity.status(HttpStatus.OK).body("PDF generated successfully at: " );
        }catch (Exception ex){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error generating PDF load");
        }
    }

}
