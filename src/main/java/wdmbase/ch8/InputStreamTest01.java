package wdmbase.ch8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

//InputStream读文件
public class InputStreamTest01 {
    public static void main(String[] args) {
        printwdm();
    }

    public static void printwdm(){
        FileInputStream fis=null;
        try {
            fis=new FileInputStream("src/main/java/wdm/ch8/wdm");
            byte[] bytes=new byte[4];

            while(true){
                int readCount=fis.read(bytes);
                if(readCount==-1){
                    break;
                }
                System.out.print(new String(bytes,0,readCount));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
