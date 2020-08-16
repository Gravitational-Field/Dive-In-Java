package lzj;


import java.io.*;

public class demo6 {

    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("he.txt");
        BufferedReader br = new BufferedReader(fr);

        StringBuilder sb = new StringBuilder();
        String text = null;
        while ((text=br.readLine())!=null){
            sb.append(text).append("\n");

        }
        System.out.println(sb);
    }

}
