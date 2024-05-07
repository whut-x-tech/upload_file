package com.example.neww;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/")
@RestController
public class testController {

    @PostMapping("/test1")
    public R ossTest1(@RequestParam("file") MultipartFile file, @RequestParam("bussessType")String bussessType){
        if(file==null){
            return R.error("The file  is empty!");
        }
        if(bussessType==null){
            return R.error("The bussessType value is empty!");
        }
        String url=OSSUtil.upLoadDocument(file,bussessType);
        System.out.println("文件路径："+url);
        return R.ok(url);
    }
}
