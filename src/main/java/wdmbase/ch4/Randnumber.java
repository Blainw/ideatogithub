package wdmbase.ch4;

import java.util.Random;

public class Randnumber {

    //生成随机数
    public static void getRandRom(){
        //产生int范围内的随机数
        Random rand=new Random();
        System.out.println( rand.nextInt());
        //产生指定范围[0-123）内的随机数,不包括123
        System.out.println( rand.nextInt(123));
    }

    //随机生成5个不同的数，放到数组中
    public static void protice(){
        Random rd=new Random();
        int[] numbers=new int[5];
        int index=0,i;
        for (i = 0; i <numbers.length ; i++) {
            numbers[i]=-1;
        }
        while(index<5){
            int num=rd.nextInt(5);
            for (i = 0; i < index; i++) {
                if(num==numbers[i])
                    break;
            }
            if(i==index)
                numbers[index++]=num;
        }
        for (i = 0; i < numbers.length; i++)
            System.out.print(numbers[i]+"  ");
    }


}
