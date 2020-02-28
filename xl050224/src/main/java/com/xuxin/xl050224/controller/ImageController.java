package com.xuxin.xl050224.controller;

import com.xuxin.xl050224.utils.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/image")
public class ImageController {

    @RequestMapping("/upload")
    public String upload(MultipartFile file){
        String fileName = FileUtils.upload(file, "E:\\movie\\movie", file.getOriginalFilename());
        return fileName;
    }

}
