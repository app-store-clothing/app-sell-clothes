package com.example.app.controller;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class FileImageUploadController {

    @PostMapping("/upload-file")
    public String uploadImage(@RequestParam("file") MultipartFile file ) throws Exception  {
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getName());
        System.out.println(file.getContentType());
        System.out.println(file.getSize());

        String pathDirectory = new ClassPathResource("static/image/").getFile().getAbsolutePath();
        Files.copy(file.getInputStream(),
                Paths.get(pathDirectory+File.separator+file.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING);

        return "Successfully";

    }
}
