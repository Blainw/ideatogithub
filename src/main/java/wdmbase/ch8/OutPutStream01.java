package wdmbase.ch8;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStream01 {
    public static void main(String[] args) {
        outFile("src/main/java/wdm/ch8/wdm");
    }

    public static void outFile(String path){
        FileOutputStream fos=null;

        try {
            byte[] byts={97,98,99,100};
            String str="我是练习时长两年半的个人练习生蔡旭框，会唱跳rap篮球";
            fos = new FileOutputStream(path,true);//加了true代表写入时是追加的，不加true默认是清空文件再写入
            fos.write(byts);
            fos.write(byts,0,2);
            fos.write(str.getBytes());
            fos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {

            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
