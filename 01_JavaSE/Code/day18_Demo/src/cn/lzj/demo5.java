package cn.lzj;

import java.io.File;
import java.util.Scanner;

public class demo5 {
    //将某文件夹下, 指定类型的文件, 整理到一起
    static String end;
    static int count = 0;
    static File newDir;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入文件路径名称：");
        String dirStr = scanner.nextLine();
        System.out.print("请输入文件后缀：");
        end = scanner.nextLine();
        System.out.print("请输入新的文件夹路径(不可为C盘，不可与输入文件路径在同一盘下)：");
        newDir = new File(scanner.nextLine());
        if (!newDir.exists()){
            newDir.mkdirs();
        }
        search(dirStr);
        System.out.println("共搜集以"+end+" 结尾的文件共："+ count+"个。");
    }

    private static void search(String dirStr) {
        File dir = new File(dirStr);
        File[] files = dir.listFiles();
        if(files!=null)
        for (File file:files) {
            if(file.isFile()){
                //是文件，
                if (file.getName().endsWith(end)) {
                    //目标文件
                    count++;
                    File newFile = new File(newDir, count+"_"+file.getName());
                    //剪切操作,demo6学习字节留后就可以复制了。
                    file.renameTo(newFile);
                    System.out.println(newFile.getAbsolutePath());
                }

            }else{
                //是文件夹
                search(file.getAbsolutePath());
            }
        }
    }
}
