package wdmbase.ch;

import java.util.*;


public class TestMain {
    public static void main(String args[]){
        Scanner s=new Scanner(System.in);
        int N=s.nextInt();//钱数
        int m=s.nextInt();//想要的物品数
        int[] value=new int[m];//价格
        int[] prior=new int[m];//重要度
        int[] qual=new int[m];//物品编号
        for(int i=1;i<=m;i++){
            value[i]=s.nextInt();
            prior[i]=s.nextInt();
            qual[i]=s.nextInt();
        }
    }

    //获取最好满意度
    public static int getMaxsta(int restMoney,int restCount,int[] value){
        if(restMoney<minValue(value)){
            return 0;
        }else if(restCount==0){
            return 0;
        }else {

        }

        return 0;
    }

    public static int minValue(int[] value){
        int[] tem=Arrays.copyOf(value,value.length);
        Arrays.sort(tem);
        return tem[0];
    }

}
