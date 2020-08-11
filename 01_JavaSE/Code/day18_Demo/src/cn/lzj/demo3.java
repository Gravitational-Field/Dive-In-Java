package cn.lzj;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo3 {

    public static void main(String[] args) {
        File file = new File("D://pic.png");
        System.out.println("文件路径为："+file.getPath());
        System.out.println("文件绝对路径为："+file.getAbsolutePath());
        System.out.println("文件名字为："+file.getName());
        System.out.println();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(file.lastModified());
        System.out.println("最后修改时间："+simpleDateFormat.format(date));
        System.out.println("文件大小为："+(file.length())/1024f + "kb");
    }
}
