package com.example.demo.controller;

import java.io.IOException;

import com.example.demo.model.DemoModel;
import com.example.demo.utility.FileUtility;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class DemoController {
    
    @PostMapping("/")
    public DemoModel postMethodName(@RequestParam("file") MultipartFile file) throws IOException {
        
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		String uploadDir = "image-upload/";
		
		FileUtility.saveFile(file, uploadDir, fileName);
        DemoModel model = new DemoModel();
        model.setFotoImage(fileName);
        return model;
    }
    
}
