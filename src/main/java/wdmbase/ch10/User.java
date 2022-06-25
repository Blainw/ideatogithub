package wdmbase.ch10;

public class User {
    public String name;
    public String password;
    protected Byte sex;
    Integer age;
    private Integer no;
    public static final Double PAI = 3.14;

    public User(String name, String password, byte sex, Integer age, Integer no) {
        this.name = name;
        this.password = password;
        this.sex = sex;
        this.age = age;
        this.no = no;
    }

    public User() {
    }

    public User(String name, String password, Integer no) {
        this.name = name;
        this.password = password;
        this.no = no;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", no=" + no +
                '}';
    }

    public boolean login(String name,String password){
        if("admin".equals(name)&&"123456".equals(password))
        return true;
        return false;
    }

    public void logout(){

    }
}
