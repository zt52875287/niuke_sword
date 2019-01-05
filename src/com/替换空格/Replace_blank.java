package com.替换空格;
/*
请实现一个函数，将一个字符串中的每个空格替换成“%20”。
例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class Replace_blank {



    public static void main(String[] args) {
        String s = " hello  world ";
        String replace = replaceSpace(new StringBuffer(s));
        System.out.println(replace);
    }

    private static String replaceSpace(StringBuffer str) {

        int index=-1;
        while((index=str.indexOf(" ")) != -1){
            str.replace(index,index+1,"%20");
        }
        return str.toString();
    }

}
