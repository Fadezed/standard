package com.zed.standard;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 描述:
 * Equals
 *
 * @author zed
 * @since 2018-11-21 3:19 PM
 */
public class Equals {
    static final float EPSILON = 0.00001f;

    public static void main(String[] args) {
        /*
         * ==判断对象是否同一个。Integer var = ?在缓存区间的赋值（见规则1），
         * 会复用已有对象，因此这个区间内的Integer使用==进行判断可通过，
         * 但是区间之外的所有数据，则会在堆上新产生，不会通过。
         * 因此如果用== 来比较数值，很可能在小的测试数据中通过，而到了生产环境才出问题。
         */

        /*
         * BigDecimal需要使用compareTo()
         * 因为BigDecimal的equals()还会比对精度，2.0与2.00不一致。
         * 因为 Atomic* 系列没有覆写equals方法。
         */

        //RIGHT
        AtomicInteger counter1 = new AtomicInteger();
        AtomicInteger counter2 = new AtomicInteger();

        if (counter1.get() == counter2.get()){
            //...
        }
        /*-------------------------------------------------------------------------------------*/

        /*
         * double及float的比较，要特殊处理
         *
         * 因为精度问题，浮点数间的equals非常不可靠，在vjkit的NumberUtil中有对应的封装函数。
         */
        float f1 = 0.15f;
        float f2 = 0.45f/3; //实际等于0.14999999

        //WRONG
        if (f1 == f2) {

        }
        if (Double.compare(f1,f2)==0)

        //RIGHT
        if (Math.abs(f1-f2)<EPSILON) {

        }

    }
}

