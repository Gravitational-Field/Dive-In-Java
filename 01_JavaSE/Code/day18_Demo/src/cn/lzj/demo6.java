package cn.lzj;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class demo6 {

    public static void main(String[] args) throws IOException {
        //文件输出流
        File file = new File("D://he.txt");
        //FileOutputStream fos = new FileOutputStream(file); //默认为非追加模式
        //FileOutputStream fos = new FileOutputStream(file,true); //此时为追加模式
        String filePath = "D://hei.txt";
        FileOutputStream fos = new FileOutputStream(filePath,true); //此时为追加模式
        byte[] bytes = "说好一起到白头，你却偷偷染了头！!\n".getBytes(); //一个汉字占两个字节

        //1. 第一种方式：每次输出一个字节
        /*for (int i = 0; i < bytes.length; i++) {
            fos.write(bytes[i]);
        }*/

        //2. 第二种方式：每次输出一个字节数组
        fos.write(bytes);

        //3. 第三种方式：每次输出一个字节数组
        //fos.write(bytes,0,bytes.length/2);

        fos.flush();
        fos.close();
        System.out.println("字节输出完毕。");

    }


}
