package wdmbase.ch8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintSreamTest01 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("输出到控制台！");
        System.setOut(new PrintStream(new FileOutputStream("src/main/java/wdm/ch8/print.txt",true)));
        System.out.println("现在输出就是输出到print.txt文件了！");
    }
}
