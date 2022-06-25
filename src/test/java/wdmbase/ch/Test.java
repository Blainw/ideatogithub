package wdmbase.ch;

import wdmbase.ch2.DateExample;
import wdmbase.ch3.NumberFormat;
import wdmbase.ch4.Randnumber;
import wdmbase.ch5.ExceptionFun;
import wdmbase.ch5.MyException;
import wdmbase.ch6.CollectionTest1;
import wdmbase.ch7.MyMap;

import java.text.ParseException;
import java.util.*;

public class Test {
    @org.junit.Test
    public void testCh1(){
            IntegerExample.example1();
    }

    @org.junit.Test
    public void testCh2() throws ParseException {
        DateExample.datetest01();
        DateExample.datetest02();
        DateExample.datetest03();
        long begin=System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
        }
        long end=System.currentTimeMillis();
        System.out.println((end-begin)+"毫秒");
    }


    @org.junit.Test
    public void testCh3(){
        NumberFormat.numberFormate();
    }

    @org.junit.Test
    public void testCh4(){
        Randnumber.getRandRom();
        Randnumber.protice();
    }

    @org.junit.Test
    public void testCh5(){
        ExceptionFun ef=new ExceptionFun();
        try {
            int i=ef.checkString("");
            if(i==1){
                System.out.println("你输入的字符串不为空");
            }
        } catch (MyException e) {
//            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
    @org.junit.Test
    public void testCh6(){
        CollectionTest1.aa();
//        CollectionTest1.bb();

    }

    @org.junit.Test
    public void testCh7(){
        MyMap<Integer,String> myMap=new MyMap<>();
        myMap.put(1,"王德明");
        myMap.put(2,"张巧玲");
        myMap.put(3,"鲁班");
        myMap.put(4,"众神之神");

        //根据key获取value
        System.out.println("key为2的值："+myMap.get(2));
        //获取键值对数量
        System.out.println("集合元素数量"+myMap.size());
        //通过key删除value
        myMap.remove(4);
        System.out.println("集合元素数量"+myMap.size());
        //判断是否包含某个key
        System.out.println("是否包含key："+myMap.containsKey(2));
        //判断是否包含某个value
        System.out.println("是否包含key："+myMap.containsValue("张巧玲"));
        //查询集合
        myMap.printMap();
        //entrySet方法获取set集合，set集合的类型是Map.Entry<Integer,String>
        Set<Map.Entry<Integer,String>> set = myMap.entrySet();
        for(Map.Entry<Integer,String> node:set){
            System.out.println(node.getKey()+"="+node.getValue());
        }
        //清除集合
        myMap.clear();
        System.out.println("集合元素数量"+myMap.size());

    }

    //测试hashset,treeset存值覆盖问题
    @org.junit.Test
    public void TestHashMap(){
        TreeSet<String> tree1=new TreeSet<>();
        tree1.add(new String("wdmbase"));
        tree1.add(new String("wdmbase"));
        TreeSet<Person> tree2=new TreeSet<>();
        tree2.add(new Person("wdmbase"));
        tree2.add(new Person("wdmbase"));
        System.out.println("tree1的大小："+tree1.size()+"，tree2的大小："+tree2.size());
        System.out.println("----------------------------");
        HashSet<String> has1=new HashSet<>();
        has1.add(new String("wdmbase"));
        has1.add(new String("wdmbase"));
        HashSet<Person> has2=new HashSet<>();
        //hashset底层hashMap，set的比较相当于map的key比较，而key比较首先是通过hash码转成的数组下标
        // 进行比较，如果数组下标一样，再通过equals比较这个数组下标上面的链表，由于person没有重写equals，所以比较的是内存地址，故判断为不相等，不能覆盖！
        has2.add(new Person("wdmbase"));
        has2.add(new Person("wdmbase"));
        System.out.println("has1的大小："+has1.size()+"，has2的大小："+has2.size());
    }

    //测试String转换成指定类型
    @org.junit.Test
    public void TestStringToOther(){
        String a="123";
        System.out.println(new StringToOther<Integer>(a).getValue().getClass().getSimpleName());
    }




}

class Person implements Comparable<Person>{
    String name;

    public Person(String name) {
        this.name = name;
    }


    @Override
    public int compareTo(Person o) {

        return o.name.compareTo(this.name);
    }
}

class StringToOther<T>{
    private T value;

    public StringToOther(String value) {

    }

    public T getValue() {
        return value;
    }
}

