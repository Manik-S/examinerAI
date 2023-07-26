package com.hackathon.examinerAI.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
public class PdfController {

    // Change this to your desired location to save the PDFs
    private static final String FILE_UPLOAD_LOCATION = "/Users/masingh/Downloads/examinerAI/src/main/resources/";

    @PostMapping("/uploadPdf")
    @CrossOrigin(origins = "http://localhost:3000")
    public String uploadPdf(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "File is empty. Please upload a PDF file.";
        }

        try {
            // Create the upload directory if it doesn't exist
            Files.createDirectories(Paths.get(FILE_UPLOAD_LOCATION));

            // Save the PDF file to the specified location
            Path filePath = Paths.get(FILE_UPLOAD_LOCATION, file.getOriginalFilename());
            Files.write(filePath, file.getBytes());

            return "PDF file successfully uploaded!";
        } catch (IOException e) {
            e.printStackTrace();
            return "Failed to upload the PDF file.";
        }
    }
}
