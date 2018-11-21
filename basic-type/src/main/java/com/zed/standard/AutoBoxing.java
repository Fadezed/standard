package com.zed.standard;

/**
 * 描述:
 * AutoBoxing
 *
 * @author zed
 * @since 2018-11-21 3:16 PM
 */
public class AutoBoxing {
    public static void main(String[] args) {
        //WRONG, sum 类型为Long， i类型为long，每次相加都需要AutoBoxing。
        Long sum=0L;

        for( long i = 0; i < 10000; i++) {
            sum+=i;
        }

        //RIGHT, 准确使用API返回正确的类型
        String str = "123";
        Integer i = Integer.valueOf(str);
        int i1 = Integer.parseInt(str);
        /*-------------------------------------------------------------------------------------*/

        //如果intObject为null，产生NPE
        Integer intObject = null;
        int i2 = intObject;
    }

}

