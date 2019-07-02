package com.zed.standard.instance;

/**
 * 描述:
 * 父类
 *
 * @author zed
 * @since 2019-06-24 8:51 AM
 */
public class Father {
    private int i = test();

    protected int test() {
        System.out.println("father non static method");
        return 0;
    }

    private static int j = method();

    private static int method() {
        System.out.println("father static method");
        return 0;
    }

    static {
        System.out.println("father static");
    }
    {
        System.out.println("father non static");
    }

}

