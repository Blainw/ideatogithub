package wdmbase.ch5;

public class ExceptionFun {
    public int checkString(String s) throws MyException {
        if(s==""){
            throw new MyException("传入的字符串不能为空！");
        }

        return 1;
    }
}
