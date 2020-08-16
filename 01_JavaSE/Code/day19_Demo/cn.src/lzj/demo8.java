package lzj;


import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class demo8 {

    public static void main(String[] args) throws IOException {
        //文件拆分
        System.out.println("请输入要切割的文件："); //D:\Download\S3DIS-20200812T120956Z-001.zip
        String inPath = new Scanner(System.in).nextLine();
        System.out.println(new FileOperate().fileCut(inPath)?"文件切割完成":"文件切割失败");


        System.out.println("请输入需要合并的文件地址：");
        String outPath = new Scanner(System.in).nextLine();
        System.out.println(new FileOperate().fileMerge(outPath)?"文件合并完成":"文件合并失败");

    }



}

class FileOperate {

    public boolean fileCut(String path) throws IOException {
        //切分文件:  1输入，多输出
        File file = new File(path);
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = null;
        File dir = new File(file.getParentFile(),"split"); //得到父路径

        if (!dir.exists()) {
            dir.mkdir();
        }

        byte[] bytes = new byte[(int) (file.length()/10+10)];
        int len = -1;
        for (int i = 0; i < 10; i++) {
            File newFile = new File(dir,file.getName()+"_split"+i+".lzj");
            fos = new FileOutputStream(newFile);
            len = fis.read(bytes);
            fos.write(bytes,0,len);
            fos.close();
        }

        fis.close();
        return true;
    }

    public boolean fileMerge(String outPath) throws IOException {
        //文件合并：多个读流，一个写流
        File[] files = new File(outPath).listFiles();
        String fileName = files[0].getName().split("_split")[0];
        FileOutputStream fos = new FileOutputStream(outPath+"//"+fileName);
        FileInputStream fis = null;
        for (File file: files) {   //要注意文件合并顺序有要求
            fis = new FileInputStream(file);
            byte[] bytes = new byte[(int) file.length()];
            int len = fis.read(bytes);
            fos.write(bytes,0,len);
            fis.close();
            file.delete();
        }

        fos.close();
        return true;
    }
}
