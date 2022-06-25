package wdmbase.ch8;

import wdmbase.ch8.utils.CopyDirectory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class FileTest01 {
    public static void main(String[] args) throws IOException {
        //File类型的使用
//        fileUse();

        System.out.println("-------------------------------------");
        //拷贝目录练习
        String sourcePath="F:\\浏览器自动下载\\谷歌浏览器";
        String targetPath="D:\\test";
        new CopyDirectory().copy(sourcePath,targetPath);

    }


    //文件的各个方法使用
    public static void fileUse() throws IOException {
        File file =new File("F:\\filetest");
        File file1 =new File("F:\\filetest\\aaa\\bbb\\ccc");
        File file2=new File("F:\\filetest\\wdm.txt");
        //目录是否存在
        System.out.println("F:\\filetest 文件是否存在： "+file.exists());
        //如果File("")文件的路径只有最后一个目录是不存在的，则用单级目录创建
        if(!file.exists()){
            file.mkdir();
        }
        //如果有多级目录都不存在，则用以下方式才能创建成功
        if(!file1.exists()){
            file1.mkdirs();
        }
        //创建文件
        if(!file2.exists()){
            file2.createNewFile();
        }
        //获取文件的父路径
        System.out.println(file2.getParent());
        //获取绝对路径
        System.out.println("获取的绝对路径："+file2.getAbsolutePath());
        //获取当前普通java项目的绝对路径
        System.out.println("获取的绝对路径："+new File("").getAbsolutePath());
        //获取文件名
        System.out.println("file2文件名是："+file2.getName());
        //判断是否是一个目录
        System.out.println("file对象是否是一个目录："+file.isDirectory());
        System.out.println("file2对象是否是一个目录："+file2.isDirectory());
        //判断是否是一个文件
        System.out.println("file对象是否是一个文件："+file.isFile());
        System.out.println("file2对象是否是一个文件："+file2.isFile());
        //获取最后一次修改时间
        long time=file2.lastModified();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("文件最后一次修改时间："+sdf.format(time));
        //向文件写入
        OutPutStream01.outFile(file2.getPath());
        //查看文件大小
        System.out.println(file2.length());
        //获取目录下的文件列表
        File[] files=file.listFiles();
        for(File f:files){
            System.out.println("文件名："+f.getName());
        }
    }




}
