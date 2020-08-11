package cn.lzj;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class demo4 {

    static String[] ends = {".tmp","._mp",".log",".gid",".chk",".old"};
    static int count = 0;
    static int countSuccess = 0;
    public static void main(String[] args) {
        String dirStr = "C://";
        clear(dirStr);
        System.out.println("垃圾文件个数："+ count);
        System.out.println("删除成功的垃圾文件个数："+ countSuccess);
    }

    private static void clear(String dirStr) {
        File dir = new File(dirStr);
        File[] files = dir.listFiles();
        if(files!=null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    //是文件夹
                    clear(file.getAbsolutePath());
                } else {
                    //是文件，判断是否是垃圾文件，是则清理，不是则不用管
                    for (String end : ends) {
                        if (file.getName().endsWith(end)) {
                            //指定后缀结尾，为垃圾文件
                            try {
                                boolean flag = file.delete();
                                if (flag) {
                                    countSuccess++;
                                    System.out.println("文件" + file.getAbsolutePath() + "删除成功！");
                                } else {
                                    //权限不足
                                    System.out.println("文件" + file.getAbsolutePath() + "删除失败！");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                System.out.println("文件" + file.getAbsolutePath() + "删除失败！");
                            }
                            count++;
                            break;
                        }
                    }

                }


            }
        }

    }
}
