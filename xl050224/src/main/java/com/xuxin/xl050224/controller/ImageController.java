package com.xuxin.xl050224.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {

    @RequestMapping("/upload")
    public String upload(@RequestParam MultipartFile file){
        return null;
    }

}
