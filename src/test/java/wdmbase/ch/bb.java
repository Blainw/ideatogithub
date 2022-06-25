package wdmbase.ch;

public class bb {
    public static void main(String[] args) throws InterruptedException {
            Thread t1=new Th();
            t1.setName("t1");
            Thread t2=new Th();
            t2.setName("t2");
            Thread t3=new Th();
            t3.setName("t3");
            t1.start();
            t2.start();
            t3.start();
    }


}

class Th extends Thread{

    @Override
    public void run() {
        this.met();
    }
    public void met(){
        System.out.println("当前线程名称："+Thread.currentThread().getName());
    }
}
