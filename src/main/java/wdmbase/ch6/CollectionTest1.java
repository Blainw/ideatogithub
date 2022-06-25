package wdmbase.ch6;

import java.util.ArrayList;
import java.util.Collection;

public class CollectionTest1 {
    public static void aa(){
        Collection c=new ArrayList();
        String a="王德明";
        c.add(a);
        String b="王德明";
        c.add(b);
        String d="王德明";
        System.out.println(c.contains(d));


        c.clear();


        a=new String("马冬梅");
        c.add(a);
        b=new String("马冬梅");
        c.add(b);
        d=new String("马冬梅");
        System.out.println(c.contains(d));
        //事实证明ArrayList的contains方法重写了equals方法，只判断地址对应的值是否存在，而不判断地址是否存在

    }
    public static void bb(){
        String a="王德明";
        String b="王德明";
        System.out.println(a==b);


        String aa=new String("王德明");
        String bb=new String("王德明");
        System.out.println(aa==bb);
    }
}
