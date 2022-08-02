package com.bw.myutils;

public class StringUtils {

    private StringUtils(){}
    private static StringUtils stringUtils;
    public static StringUtils getInstance(){
        if(stringUtils == null){
            synchronized (StringUtils.class){
                if(stringUtils == null){
                    stringUtils = new StringUtils();
                }
            }
        }
        return  stringUtils;
    }

    public String da(String string){
        return string.toUpperCase();
    }


}
