package wdmbase.ch;

import java.util.*;

public class aa {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        char[] chs=s.nextLine().toCharArray();
        for(int i=0;i<chs.length;i++){
            if(chs[i]>='A'&&chs[i]<'Z'){
                chs[i]+=33;
                continue;
            }
            if(chs[i]=='Z'){
                chs[i]='a';
                continue;
            }
            if(chs[i]>='a'&&chs[i]<='c'){
                chs[i]='2';
                continue;
            }
            if(chs[i]>='d'&&chs[i]<='f'){
                chs[i]='3';
                continue;
            }
            if(chs[i]>='g'&&chs[i]<='i'){
                chs[i]='4';
                continue;
            }
            if(chs[i]>='j'&&chs[i]<='l'){
                chs[i]='5';
                continue;
            }
            if(chs[i]>='m'&&chs[i]<='o'){
                chs[i]='6';
                continue;
            }
            if(chs[i]>='p'&&chs[i]<='s'){
                chs[i]='7';
                continue;
            }
            if(chs[i]>='t'&&chs[i]<='v'){
                chs[i]='8';
                continue;
            }
            if(chs[i]>='w'&&chs[i]<='z'){
                chs[i]='9';
                continue;
            }
        }

        System.out.println(new String(chs));

    }
}
