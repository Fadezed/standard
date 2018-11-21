package com.zed.standard;

import java.util.regex.Pattern;

/**
 * 描述:
 * 正则表达式
 *
 * @author zed
 * @since 2018-11-21 4:52 PM
 */
public class Match {
    public static void main(String[] args) {
        /*
         * 反例
         */
        //直接使用String的matches()方法
        Boolean result ;
        result = "abc".matches("[a-zA-z]");

        //每次重新构造Pattern
        Pattern pattern = Pattern.compile("[a-zA-z]");
        result = pattern.matcher("abc").matches();

        /*
         * 正例
         */

        //真正使用Pattern的地方
        result = Util.pattern1.matcher("abc").matches();
    }
    private static class Util{
        //在某个地方预先编译Pattern，比如类的静态变量
        private static Pattern pattern1 = Pattern.compile("[a-zA-z]");
    }
}

