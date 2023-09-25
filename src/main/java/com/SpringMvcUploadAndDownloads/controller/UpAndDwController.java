package com.SpringMvcUploadAndDownloads.controller;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

@Controller
@RequestMapping("/ud")
public class UpAndDwController {

    @GetMapping("/index")
    public String index() {
        return "DownloadAndUpload";
    }

    @ResponseBody
    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {

        File fileObj = new File("uploadTest.png");
        file.transferTo(fileObj);
        System.out.println("用户上传的文件已保存到: " + fileObj.getAbsolutePath());
        return "The File Is Uploaded Success Fully";

    }

    @ResponseBody
    @GetMapping("/download")
    public void download(HttpServletResponse response) {

        response.setContentType("multipart/form-data");
        try (ServletOutputStream stream = response.getOutputStream();
             InputStream inputStream = new FileInputStream("D:/Users/Downloads/uploadTest.png")) {

            IOUtils.copy(inputStream, stream);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
