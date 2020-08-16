package lzj;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class demo3 {

    public static void main(String[] args) throws IOException {
        //字符输出流
        //File file = new File("he.txt"); //输出流不用管
        FileWriter fileWriter = new FileWriter("he.txt",true); //追加模式
        fileWriter.write("青天已死，黄天当立");

        fileWriter.flush(); //必须刷新或者关闭
        fileWriter.close();
    }
}
