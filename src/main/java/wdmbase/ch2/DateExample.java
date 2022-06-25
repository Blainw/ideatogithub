package wdmbase.ch2;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {

    //date类型日期按照格式转换成字符串
    public static void datetest01(){
        //获取当前系统时间
        Date systemdate=new Date();
        //日期格式化
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        //将当前日期格式化
        String formatedate=sdf.format(systemdate);
        System.out.println(formatedate);
    }

    //将时间字符串转换成date日期格式
    public static void datetest02() throws ParseException {
        //输入日期字符串
        String date="2022/05-09 17:54:39";
        //输入和日期字符串一样的格式，必须一样才能转换
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM-dd HH:mm:ss");
        //用parse（）方法进行转换
        System.out.println(sdf.parse(date));
    }

    //获取自1970年1月1日 00:00:00 000到当前系统时间的总毫秒数
    public static void datetest03() throws ParseException {
        System.out.println(System.currentTimeMillis());

    }
}
