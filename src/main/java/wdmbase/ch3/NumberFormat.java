package wdmbase.ch3;

import java.text.DecimalFormat;

public class NumberFormat {

    //数字格式化
    public static void numberFormate(){
        //按照千分位，四位小数进行格式化给定数字
        DecimalFormat df=new DecimalFormat("###,###.####");
        String result=df.format(13145207.5678);
        //小数位不够补零
        DecimalFormat df2=new DecimalFormat("###,###.0000");
        String result2=df2.format(1234.56);
        System.out.println(result);
        System.out.println(result2);
    }


}
