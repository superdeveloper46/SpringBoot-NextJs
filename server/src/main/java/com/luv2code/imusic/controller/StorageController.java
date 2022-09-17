package com.luv2code.imusic.controller;

import com.luv2code.imusic.service.StorageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Controller
@RestController
@RequestMapping("/file")
public class StorageController {
    private final Logger log = LoggerFactory.getLogger(StorageController.class);
    @Autowired
    private StorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam(value = "file") MultipartFile file) throws IOException {
        return new ResponseEntity<>(storageService.uploadFile(file), HttpStatus.OK);
    }

}
