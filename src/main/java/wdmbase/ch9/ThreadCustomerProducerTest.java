package wdmbase.ch9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreadCustomerProducerTest {
    public static void main(String[] args) {
        List<Integer> list= new ArrayList();
        Thread t1=new Thread(new Producer(list));
        Thread t2=new Thread(new Customer(list));
        t1.setName("生产者线程");
        t2.setName("消费者线程");
        t1.start();
        t2.start();
    }
}


//生产者
class Producer implements Runnable{
    private List<Integer> list;
    public Producer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (list){//同步代码块
                if(list.size()>10){
                    try {
                        list.wait();//让正在list对象上活动的线程进入等待状态
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Integer i= new Random().nextInt(123);
                    list.add(i);
                    System.out.println(Thread.currentThread().getName()+"生产了数字："+i);
                    list.notifyAll();//唤醒所有等待

            }
        }
    }
}

//消费者
class
Customer implements Runnable{
    private List<Integer> list;
    public Customer(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while(true){
            synchronized (list){
                if(list.size()==0){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                    Integer removeNum=list.remove(0);
                    System.out.println(Thread.currentThread().getName()+"消费了数字："+removeNum);
                    list.notifyAll();

            }
        }
    }
}