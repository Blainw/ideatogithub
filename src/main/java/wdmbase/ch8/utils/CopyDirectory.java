package wdmbase.ch8.utils;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.TimeZone;

public class CopyDirectory {

    //单个文件拷贝
    public void filecopy(String sourcePath,String targetPath){
        FileInputStream fis=null;
        FileOutputStream fos=null;
        try {
            byte[] byts=new byte[1024*1024];//一次最多拷贝1M
            int readCout=0;
            fis=new FileInputStream(sourcePath);
            fos=new FileOutputStream(targetPath);//如果是清空所有文件，再写入，就这样写即可，如果是在原文追加，则在后面添加一个true;
            while((readCout=fis.read(byts))!=-1){
                fos.write(byts,0,readCout);
            }
            fos.flush();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {


            if(fis!=null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if(fos!=null){
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    //拷贝
    public void copy(String sourcePath,String targetPath){
        initiate(sourcePath,targetPath);
    }
    //初始化
    public void initiate(String sourcePath,String targetPath){
        File file=new File(sourcePath);
        if(check(file,targetPath)){
            System.out.println("可以复制了！");
            long begin=System.currentTimeMillis();
            try {
                copyDir(new File(sourcePath),targetPath);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            long end=System.currentTimeMillis();
            TimeZone.setDefault(TimeZone.getTimeZone("GMT+0"));
            SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss SSS");
            System.out.println("复制成功！用时："+sdf.format(end-begin));
        }
    }

    //拷贝目录前的检查工作
    public boolean check(File file,String targetPath){
        if(!new File(targetPath).exists()){
            new File(targetPath).mkdirs();
            return true;
        }
        File[] list=new File(targetPath).listFiles();
        if(list.length==0){
            return true;
        }
        if(list.length>0){
            for(File f:list){
                if(f.isDirectory()){
                    if(f.getName().equals(file.getName())){
                        System.out.println("目标目录存在此文件夹,是否覆盖？y/n:");
                        Scanner s=new Scanner(System.in);
                        String result=s.next();
                        if("y".equals(result)){
                            return true;
                        }else{
                            return false;
                        }
                    }
                }
            }
        }
        return false;
    }

    //拷贝目录
    public boolean copyDir(File file,String targetPath) throws IOException {
        targetPath+="\\"+file.getName();
        if(file.isDirectory()){
            new File(targetPath).mkdir();
            File[] list=file.listFiles();
            if(list.length>0){
                for(File f:list){
                    copyDir(f,targetPath);
                }
            }
        }
        if(file.isFile()){
            String path=file.getPath();
            filecopy(path,targetPath);
        }
        return true;
    }
}
