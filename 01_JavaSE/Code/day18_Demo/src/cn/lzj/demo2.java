package cn.lzj;

import java.io.File;
import java.io.IOException;

public class demo2 {

    public static void main(String[] args) {
        File file = new File("D://lzj.md"); //相对路径
        try {
            file.createNewFile(); //受检异常
        } catch (IOException e) {
            e.printStackTrace();
        }

        boolean f1 = file.delete();
        System.out.println(file.getAbsoluteFile()); //D:\lzj.md
        System.out.println(file.getPath()); //D:\lzj.md
        System.out.println(file.getName()); //lzj.md

    }
}
