package com.lzj.servlet;




import org.apache.commons.io.IOUtils;
import sun.misc.BASE64Encoder;


import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //文件下载5步骤
        //1. 获取要下载的文件名
        String downloadFileName = "1.png";

        ServletContext servletContext = getServletContext();
        //2. 获取下载文件的文件类型
        String mimeType = servletContext.getMimeType(downloadFileName);
        System.out.println("下载的文件类型为："+mimeType);

        //3. 在回传前告诉客户端返回的数据类型
        resp.setContentType(mimeType);
        //4. 要告诉客户端收到的数据是用于下载使用（还是使用响应头）
        // Content-Disposition 响应头，表示收到的数据怎么处理
        // attachment 表示附件，表示下载使用
        // filename= 表示指定下载的文件名
        String ua = req.getHeader("User-Agent");
        if(ua.contains("Firefox")){
            //火狐浏览器，使用BASE64编码，才可以保存中文文件
            String str = "attachment; fileName=" + "=?utf-8?B?" +
                    new BASE64Encoder().encode("北京.png".getBytes("utf-8")) + "?=";
            resp.setHeader("Content-Disposition",str); //文件名可指定
        } else{
            //其它浏览器：google、IE
            //Content-Disposition: attachment; filename=%E5%8C%97%E4%BA%AC.png
            resp.setHeader("Content-Disposition","attachment; filename="+ URLEncoder.encode("北京.png","UTF-8")); //文件名可指定
        }

        //获取响应的输出流
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFileName);
        ServletOutputStream outputStream = resp.getOutputStream();
        // 将文件内容回传给客户端
        //5. 读取输入流中全部的数据，复制给输出流，输出给客户端
        IOUtils.copy(resourceAsStream,outputStream);

    }
}
