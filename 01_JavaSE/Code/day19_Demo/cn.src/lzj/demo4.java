package lzj;


import javax.xml.bind.SchemaOutputResolver;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class demo4 {

    public static void main(String[] args) throws IOException {
        //
        File file = new File("he.txt");
        FileReader fr = new FileReader(file);
        char[] chars = new char[10];
        int len = -1;
        while ((len=fr.read(chars,0,4))!=-1){
            System.out.print(chars);
        }

        fr.close();
    }
}
