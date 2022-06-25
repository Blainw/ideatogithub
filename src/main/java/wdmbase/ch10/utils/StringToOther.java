package wdmbase.ch10.utils;

public class StringToOther {
    //将String类型转换成指定类型
    public static Object transForm(String data,String target){
        if("String".equals(target)){
            return data;
        }
        if("Integer".equals(target)||"int".equals(target)){
            return Integer.parseInt(data);
        }
        if("Float".equals(target)||"float".equals(target)){
            return Float.parseFloat(data);
        }
        if("Double".equals(target)||"double".equals(target)){
            return Double.parseDouble(data);
        }
        if("Byte".equals(target)||"byte".equals(target)){
            return Byte.parseByte(data);
        }
        if("Short".equals(target)||"short".equals(target)){
            return Short.parseShort(data);
        }
        if("Long".equals(target)||"long".equals(target)){
            return Long.parseLong(data);
        }
        if("Char".equals(target)||"char".equals(target)){
            return data.charAt(0);
        }
        if("Boolean".equals(target)||"boolean".equals(target)){
            return Boolean.parseBoolean(data);
        }
        return null;
    }
}
