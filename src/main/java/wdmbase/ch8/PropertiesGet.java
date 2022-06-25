package wdmbase.ch8;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesGet {
    public static void main(String[] args) throws IOException {
        FileInputStream fis= new FileInputStream("src/main/java/wdm/ch8/config/user.properties");
        Properties pro=new Properties();
        pro.load(fis);
        System.out.println(pro.getProperty("username"));
        System.out.println(pro.getProperty("password"));
        System.out.println(pro.getProperty("id"));
    }
}
