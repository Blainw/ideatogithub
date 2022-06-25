package wdmbase.ch11;

public class User {
    @MyAnnotation("王德明")
    public String name;
    @MyAnnotation("123")
    public String password;
    @MyAnnotation("1")
    protected Byte sex;
    @MyAnnotation("18")
    Integer age;
    @MyAnnotation("1003")
    private Integer no;
    public static final Double PAI = 3.14;

    public void setNo(Integer no) {
        this.no = no;
    }


    public User() {
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

}
