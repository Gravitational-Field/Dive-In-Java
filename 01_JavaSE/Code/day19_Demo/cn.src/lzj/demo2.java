package lzj;

import java.io.*;

public class demo2 {

    public static void main(String[] args) throws IOException {
        //相当于完成一个文件复制操作
        File file = new File("D:\\带网卡版驱动精灵.exe");
        File newFile = new File("D:\\BaiduDocuments\\带网卡版驱动精灵.exe");

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(newFile);

        byte[] bytes = new byte[1024*1024*10];
        int len = -1;
        long length = file.length();
        long count = 0;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes);
            count += len;
            System.out.println("文件传输： "+count/(length/100)+"%");
        }

        fis.close();
        fos.close();
        System.out.println("文件输出成功");

    }
}
