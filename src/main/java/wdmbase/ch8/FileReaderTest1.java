package wdmbase.ch8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest1 {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("src/main/java/wdm/ch8/wdm");
            char[] chs = new char[4];
            int readCount = 0;
            while ((readCount = fr.read(chs)) != -1) {
                System.out.print(new String(chs, 0, readCount));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fr != null) {
                try {
                    fr.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
