package wdmbase.ch8;

import java.io.*;

public class BufferReadTest01 {
    public static void main(String[] args) throws IOException {
        //获取字节流
        FileInputStream fis=new FileInputStream("C:\\Users\\Administrator\\Desktop\\新建文本文档 (3).txt") ;
        //将字节流转换成字符流read
        InputStreamReader fr=new InputStreamReader(fis);
        //将字符流对象传入缓冲流
        BufferedReader br=new BufferedReader(fr);

        String s="";
        while((s=br.readLine())!=null){//读出的文本没有换行，这里输出换了行是因为println（），读完最后就指向空；
            System.out.println(s);
        }

        br.close();
    }
}
