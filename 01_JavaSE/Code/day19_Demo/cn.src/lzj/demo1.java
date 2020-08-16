package lzj;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class demo1 {

    public static void main(String[] args) throws IOException {
        //文件的输入流
        File file = new File("D://hei.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        //1. fis.read()   一次读取一个字节，读到末尾返回-1
        /*byte[] bytes = new byte[(int)file.length()];
        int len = -1;
        int index = 0;
        while ((len=fileInputStream.read())!=-1){
            bytes[index++] = (byte) len;
        }
        */

        //2.一次读取一个字节数组
        /*byte[] bytes = new byte[(int)file.length()];
        int len = fileInputStream.read(bytes);*/

        //3. 有偏移的读取
        byte[] bytes = new byte[1024];
        int len = fileInputStream.read(bytes, 20, 99); //从bytes[20]开始存
        System.out.println(len);
        String text = new String(bytes);
        System.out.println(text);
    }
}
