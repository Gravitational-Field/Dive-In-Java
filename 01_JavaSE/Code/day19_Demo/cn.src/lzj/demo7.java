package lzj;


import java.io.*;

public class demo7 {

    public static void main(String[] args) throws IOException {
        //打印字符
        //PrintWriter printWriter = new PrintWriter(new FileWriter("he.txt",true));
        PrintStream printStream = new PrintStream(new FileOutputStream("he.txt",true));
        //与PrintStream完全一致
        printStream.println("该出手时就出手。\n");

        printStream.flush();
        printStream.close();

    }
}
