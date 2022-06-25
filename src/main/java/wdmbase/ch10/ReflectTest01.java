package wdmbase.ch10;


import org.junit.jupiter.api.Test;
import wdmbase.ch10.utils.StringToOther;

import java.io.FileInputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Properties;
import java.util.ResourceBundle;

public class ReflectTest01 {
    //获取Class文件的方式
    @Test
    public void Test01() throws Exception {

        //获取class文件的第一种方式Class.forName（）
        Class c1=Class.forName("java.lang.String");
        System.out.println(c1);
        //获取class文件的第二种形式getClass（）方法
        System.out.println("abc".getClass());
        //获取class文件的第三种形式，类名.class属性
        System.out.println(String.class);
    }

    //反射机制创建对象
    @Test
    public void Test02() throws Exception {
        //通过反射机制创建对象
        Class c=Class.forName("wdmbase.ch10.User");
        Object obj=c.newInstance();
        System.out.println(obj );
    }

    //获取资源文件路径
    @Test
    public void Test03() throws Exception {
        //动态获取资源的绝对路径（资源以当前类路径为起点，现在src/main/java是类路径,所以这里填的资源名称是在从java开始，往下找的路径）
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("GetPathTest.properties").getPath());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource("wdmbase/ch10/test.properties").getPath());

        //资源绑定器获取文件,只能获取.properties文件，且这个后缀不能加
        ResourceBundle rb= ResourceBundle.getBundle("wdmbase/ch10/test");
        System.out.println(rb.getString("username"));
    }

    //获取类中的属性
    @Test
    public void Test04() throws Exception {
        //获取类中的public修饰的属性
        Class userClass=Class.forName("wdmbase.ch10.User");
        Field[] fields=userClass.getFields();
        for(Field f:fields){
            System.out.println(f.getName());
        }
        System.out.println("------------------------------------");
        //获取类中的所有属性
        Class user1=Class.forName("wdmbase.ch10.User");
        Field[] fields1=user1.getDeclaredFields();
        for(Field f:fields1){
            System.out.println(f.getName());
        }
        System.out.println("------------------------------------");
        //获取属性的类型
        Class user2=Class.forName("wdmbase.ch10.User");
        Field[] fields2=user1.getDeclaredFields();
        for(Field f:fields1){
            System.out.println("属性名："+f.getName()+"   的全限定类型名称是："+f.getType()+" 类型名称是："+f.getType().getSimpleName());
        }
        System.out.println("------------------------------------");
        //获取属性的修饰符列表
        Class user3=Class.forName("wdmbase.ch10.User");
        Field[] fields3=user3.getDeclaredFields();
        for(Field f:fields3){
            System.out.println("属性名："+f.getName()+" 的修饰符是："+ Modifier.toString(f.getModifiers()));
        }
    }

    //通过反射机制，反编译一个类的属性Field
    @Test
    public void Test05() throws Exception {
        StringBuilder sb=new StringBuilder();
        Class c=Class.forName("wdmbase.ch10.User");
        sb.append(Modifier.toString(c.getModifiers())+" class "+c.getSimpleName()+"{\n");
        Field[] fileds=c.getDeclaredFields();
        for(Field f:fileds){
            sb.append("\t"+Modifier.toString(f.getModifiers())+" "+f.getType().getSimpleName()+" "+f.getName()+";\n");
        }
        sb.append("}");
        System.out.println(sb);
    }

    //通过反射机制，给属性赋值
    @Test
    public void Test06() throws Exception {
        //根据类的全限定名称获取类
        Class user=Class.forName("wdmbase.ch10.User");
        //创建一个实例
        Object obj= user.newInstance();
        //获取到属性
        Field age=user.getDeclaredField("age");
        Field no=user.getDeclaredField("no");
        Field PAI=user.getDeclaredField("PAI");
        //给属性赋值，注意private不能赋值，除非设置setAccessible为true,但静态变量还是不能赋值
        age.set(obj,99);
        //设置setAccessible为true
        no.setAccessible(true);
        no.set(obj,123);
        //获取age属性的值
        System.out.println(age.get(obj)+"   "+no.get(obj)+"   ");
    }

    //通过反射机制，给属性赋值(改进版，更加灵活，通过文件来获取值)
    @Test
    public void Test07() throws Exception {
        //获取文件的第一种方式
        Properties pro=new Properties();
        pro.load(new FileInputStream("src/main/java/wdm/ch10/field.properties"));
        System.out.println(pro.getProperty("name"));

        System.out.println("----------------------------------");
        //获取文件的第二种方式，以类路径为起点，通过此虚拟路径动态获取绝对路径
        String path=Thread.currentThread().getContextClassLoader().getResource("wdmbase/ch10/field.properties").getPath();
        Properties pro1=new Properties();
        pro.load(new FileInputStream(path));
        System.out.println(pro.getProperty("password"));

        System.out.println("----------------------------------");
        //获取文件的第三种方式,资源绑定器获取文件,只能获取.properties文件，且这个后缀不能加
        ResourceBundle rb=ResourceBundle.getBundle("wdmbase/ch10/field");
        System.out.println(rb.getString("no"));

        //正式改进,此改进用的是第三种方式获取文件，目前只支持八种基本数据类型以及八种引用数据类型
        Class user=Class.forName(rb.getString("classname"));
        //创建一个实例
        Object obj= user.newInstance();
        //获取到属性列表
        Field[] fields=user.getDeclaredFields();
        for(Field f:fields){
            //如果是静态变量，则直接跳过，不给其赋值
            if(Modifier.toString(f.getModifiers()).contains("static")){
                continue;
            }
            //如果是私有变量，则先设置setAccessible为true，再赋值
            if(Modifier.toString(f.getModifiers()).contains("private")){
                f.setAccessible(true);
                //将从文件中获取到的String类型的值，转换成当前属性的类型
                f.set(obj,StringToOther.transForm(rb.getString(f.getName()),f.getType().getSimpleName()));
            }
            f.set(obj,StringToOther.transForm(rb.getString(f.getName()),f.getType().getSimpleName()));
        }

        System.out.println(obj);
    }

    //反射获取方法
    @Test
    public void test08() throws Exception {
        Class user=Class.forName("wdmbase.ch10.User");
        //获取所有方法
        Method[] methods=user.getDeclaredMethods();
        for(Method m:methods){
            //获取方法修饰符列表
            System.out.print(Modifier.toString(m.getModifiers())+"   ");
            //获取方法的返回值类型
            System.out.print(m.getReturnType().getSimpleName()+"   ");
            //获取方法名
            System.out.print(m.getName()+"   ");
            //获取方法的参数列表的所有类型
            Class[] classes=m.getParameterTypes();
            for(Class c:classes){
                System.out.print(c.getSimpleName()+"   ");
            }
            System.out.println();
        }
    }

    //利用反射机制调用方法,反射机制中的超重点*************************invoke方法
    @Test
    public void test09() throws Exception {
        //获取类名
        Class user=Class.forName("wdmbase.ch10.User");
        //创建对象
        Object obj=user.newInstance();
        //获取方法名,第一个是方法名，后面是参数列表的类型
        Method method=user.getDeclaredMethod("login",String.class,String.class);
        //调用方法,第一个是对象名，后面是参数列表
        Object returnValue=method.invoke(obj,"admin","12345");
        System.out.println(returnValue);
    }

    //通过反射机制，获取构造方法，并用构造方法创建对象
    @Test
    public void test10() throws Exception {
        Class user=Class.forName("wdmbase.ch10.User");
        //调用无参数构造方法，其实就是newInstance
        Object obj=user.newInstance();
        //拿到有参数的构造方法,因为构造方法的名称是固定的，所以这里直接传入参数类型，和Method有区别
        Constructor c=user.getDeclaredConstructor(String.class,String.class,Integer.class);
        //调用有参数的构造方法
        Object obj1=c.newInstance("wdmbase","123",1002);
        System.out.println(obj);
        System.out.println(obj1);
    }

    //获取类的父类，或者已实现的接口
    @Test
    public void test11() throws Exception {
        Class string =Class.forName("java.lang.String");
        //获取String类的父类
        System.out.println(string.getSuperclass().getSimpleName());
        //获取String类的所有接口
        Class[] intefaces= string.getInterfaces();
        for(Class c:intefaces){
            System.out.println(c.getName());
        }
    }
}

