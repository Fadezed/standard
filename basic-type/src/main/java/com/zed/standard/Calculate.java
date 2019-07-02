package com.zed.standard;

/**
 * 描述:
 * Calculate
 *
 * @author zed
 * @since 2018-11-21 3:23 PM
 */
public class Calculate {
    public static void main(String[] args) {

        /*
         * int与int相除后，哪怕被赋值给float或double，结果仍然是四舍五入取整的int。
         *
         *  需要强制将除数或被除数转换为float或double。
         */
        //结果是3.0
        double d = 24/7;
        //结果是正确的3.42857
        double d1 =  (double)24/7;
        /*-------------------------------------------------------------------------------------*/


        /*
         * int与int相乘，哪怕被赋值给long，仍然会溢出。
         *
         * 需要强制将乘数的一方转换为long。
         */
        // 结果是溢出的－2
        long l = Integer.MAX_VALUE * 2;
        //结果是正确的4294967294
        long l1 = Integer.MAX_VALUE * 2L;
        //另外，int的最大值约21亿，留意可能溢出的情况。

        /*-------------------------------------------------------------------------------------*/

        /*
         * 取模做数组下标时，如果不处理负数的情况，很容易ArrayIndexOutOfBoundException。
         *
         * 另外，Integer.MIN_VALUE取绝对值也仍然是负数。参考vjkit的MathUtil做的安全封装。
         */
        //结果为 -1
        System.out.println(-4 % 3);
        //-2147483648
        System.out.println(Math.abs(Integer.MIN_VALUE));
        /*-------------------------------------------------------------------------------------*/

        /*
         *  double 或 float 计算时有不可避免的精度问题
         */
        //结果是0.14999999
        float f = 0.45f/3;
        System.out.println(f);
        //结果是正确的0.15
        double d12 = 0.45d/3;
        System.out.println(d12);
        //结果是0.6100000000000001
        double d2 = 1.03d - 0.42d;
        System.out.println(d2);

        /*
         * 尽量用double而不用float，但如果是金融货币的计算，则必须使用如下选择：
         *
         * 选项1， 使用性能较差的BigDecimal。BigDecimal还能精确控制四舍五入或是其他取舍的方式。
         *
         * 选项2， 在预知小数精度的情况下，将浮点运算放大为整数计数，比如货币以"分"而不是以"元"计算。
         */
    }
}

