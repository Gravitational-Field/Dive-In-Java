package com.lzj.servlet;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServletJar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html; charest=UTF-8");

        //1. 判断上传数据是否为多段数据（只有是多段的数据，才是文件上传）
        if(ServletFileUpload.isMultipartContent(req)){

            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

            List<FileItem> list = null;
            try {
                list = servletFileUpload.parseRequest(req);
                for (FileItem fileItem:list) {

                    if(fileItem.isFormField()){
                        //普通表单项
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());
                        System.out.println("表单项的value属性值："+fileItem.getString());  //中文会乱码
                    } else{
                        // 上传的文件
                        System.out.println("表单项的name属性值："+fileItem.getFieldName());  //photo
                        System.out.println("上传的文件名："+fileItem.getName());

                        fileItem.write(new File("d://"+fileItem.getName()));  //传回到本地
                        String realPath = getServletContext().getRealPath("/");
                        System.out.println("realPath:"+realPath);
                        // D:\微云同步助手\810968336\JavaWeb\JavaWeb\out\artifacts\00_SimpleModule_war_exploded\
                        //System.out.println("req.getServletPath():"+req.getServletPath());
                        File file = new File(realPath+"file/"+fileItem.getName());
                        fileItem.write(file);
                        System.out.println("file upload success!!");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
