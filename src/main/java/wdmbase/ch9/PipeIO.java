package wdmbase.ch9;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeIO {

    public static void main(String[] args) {
        final PipedInputStream pis=new PipedInputStream();
        final PipedOutputStream pos=new PipedOutputStream();
        try {
            pis.connect(pos);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                write(pos);
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                read(pis);
            }
        }).start();
    }
    public static void write(PipedOutputStream pos){
        String s="我是王德明dsd212123123d1232s12d31s";
        try {
            pos.write(s.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void read(PipedInputStream pis){
        byte[] bytes=new byte[3];
        int len=0;
        try {
            while((len=pis.read(bytes))!=-1){
                System.out.print(new String(bytes,0,len));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                pis.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

