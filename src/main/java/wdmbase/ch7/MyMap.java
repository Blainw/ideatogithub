package wdmbase.ch7;

import java.util.*;

public class MyMap<K,V> extends HashMap {
    public void printMap(){
        Set<K> keys=this.keySet();
        Iterator<K> it = keys.iterator();
        while (it.hasNext()){
            K key=it.next();
            System.out.println("键是："+key+"值是："+this.get(key));
        }

    }



}
