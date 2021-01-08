package com.lzj.servlet;

import org.apache.commons.fileupload.FileUpload;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("图片上传成功");
        ServletInputStream inputStream = req.getInputStream();

        byte[] buffer = new byte[1024000];
        int read = inputStream.read(buffer);
        System.out.println(new String(buffer,0,read));
        String path = getServletContext().getRealPath("/");
        File file = new File(path+"/file/"+"4.png");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(buffer,0,read);

        inputStream.close();
        fileOutputStream.close();
    }
}
