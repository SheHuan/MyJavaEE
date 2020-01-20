package com.shh.ssm.controller;

import com.shh.ssm.pojo.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/file")
public class FileController {
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, MultipartFile file) throws IOException {
        String path = request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        String fileName = file.getOriginalFilename();
        fileName = UUID.randomUUID().toString().replace("-", "") + "_" + fileName;
        File f = new File(path);
        if (!f.exists()) {
            f.mkdirs();
        }
        file.transferTo(new File(path, fileName));
        return "success";
    }

    @RequestMapping("/uploadForm")
    public String upload() {
        return "upload";
    }

    @RequestMapping("/error")
    public void error() throws MyException {
        throw new MyException("测试异常");
    }
}
