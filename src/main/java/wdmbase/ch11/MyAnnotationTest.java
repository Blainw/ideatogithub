package wdmbase.ch11;

import org.junit.jupiter.api.Test;
import wdmbase.ch10.utils.StringToOther;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class MyAnnotationTest {

    //获取通过注解赋的值，并将值通过反射机制传给对象，然后输出
    @Test
    public void Test01() throws Exception{
        Class user=Class.forName("wdmbase.ch11.User");
        Field[] fields=user.getDeclaredFields();
        //通过无参数构造方法创建对象
        Object obj=user.getConstructor().newInstance();
        for(Field f:fields){
            //如果存在此注解类型，则执行if
            if(f.isAnnotationPresent(MyAnnotation.class)){
                //获取注解
                MyAnnotation annotation=(MyAnnotation)f.getAnnotation(MyAnnotation.class);
                //获取注解的值,value值为String，利用工具类StringToOther转换成对应类型
                String value=annotation.value();
                //获取注解的赋值,并将值反射给对应属性
                if(Modifier.toString(f.getModifiers()).contains("static")){
                    continue;
                }
                if(Modifier.toString(f.getModifiers()).contains("private")){
                    //如果是私有属性，通过set方法赋值
                    Method method=user.getMethod("set"+f.getName().substring(0,1).toUpperCase()+f.getName().substring(1),f.getType());
                    method.invoke(obj,StringToOther.transForm(value,f.getType().getSimpleName()));
                }else{
                    //其它情况直接赋值
                    f.set(obj, StringToOther.transForm(value,f.getType().getSimpleName()));
                }

            }
        }
        System.out.println(obj);

    }
}
