package wdmbase.ch9;

public class protice {
    public static void main(String[] args) {
        //实现两个线程交替输出数字，1  2  3  4  5....
        int[] num=new int[]{1};
        Thread t1=new Thread(new Thread1(num));
        Thread t2=new Thread(new Thread2(num));
        t1.setName("t1");
        t2.setName("t2");
        t1.start();
        t2.start();
    }
}

//输出奇数
class Thread1 implements Runnable{
    int[] num;

    public Thread1(int[] num) {
        this.num = num;
    }

    @Override
    public void run() {
        while(true){
            synchronized (num){
                if(num[0]%2==0){
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"--->"+(num[0]++));
                num.notifyAll();
            }
        }
    }
}

//输出偶数
class Thread2 implements Runnable{

    int[] num;

    public Thread2(int[] num) {
        this.num = num;
    }

    @Override
    public void run() {
        while(true){
            synchronized (num){
                if(num[0]%2!=0){
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName()+"--->"+(num[0]++));
                num.notifyAll();
            }
        }
    }
}
