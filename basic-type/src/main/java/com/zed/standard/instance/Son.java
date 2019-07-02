package com.zed.standard.instance;

/**
 * 描述:
 * Son
 *
 * @author zed
 * @since 2019-06-24 8:51 AM
 */
public class Son extends Father {
    private int i = test();
    @Override
    public int test() {
        System.out.println("Son non static method");

        return 0;
    }

    private static int j = method();

    private static int method() {
        System.out.println("Son static method");
        return 0;
    }

    static {
        System.out.println("Son static");
    }
    {
        System.out.println("Son non static");
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println("-------");
        Son s2 = new Son();
        System.out.println("-------");
    }

}

