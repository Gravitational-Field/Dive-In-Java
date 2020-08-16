package lzj;

import java.io.*;

public class demo5 {

    public static void main(String[] args) throws IOException {
        //涉及装饰者模式
        //1. 字节流转换成字符流
        /*FileOutputStream fos = new FileOutputStream("he.txt",true);
        OutputStreamWriter osw = new OutputStreamWriter(fos);

        osw.write("天若有情天亦老。");

        osw.flush();
        fos.close();
        osw.close();*/

        //2. 字节流转换成字符流
        File file = new File("he.txt");
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        char[] chars = new char[100];
        int len = isr.read(chars);
        System.out.println(chars);

        isr.close();
        fis.close();

    }
}
