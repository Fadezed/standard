package com.zed.standard;

/**
 * 描述:
 * StrConcat
 *
 * @author zed
 * @since 2018-11-21 4:29 PM
 */
public class StrConcat {
    /**
     *  当字符串拼接不在一个命令行内写完，而是存在多次拼接时(比如循环)，使用StringBuilder的append()
     */
    public static void main(String[] args) {
        /*
         * 反编译出的字节码文件显示，其实每条用+进行字符拼接的语句，都会new出一个StringBuilder对象，
         * 然后进行append操作，最后通过toString方法返回String对象。
         * 所以下面两个错误例子，会重复构造StringBuilder，重复toString()造成资源浪费。
         */
        String str1 = "zed";
        String str2 = "fade";
        String s  = "hello" + str1 +  str2;  //Almost OK，除非初始长度有问题，见第3点.

        String s1  = "hello";  //WRONG
        if (true) {
            s += str1;
        }

        String str = "start";       //WRONG
        for (int i = 0; i < 100; i++) {
            str = str + "hello";
        }
        /*-------------------------------------------------------------------------------------*/


        /*
         *字符串拼接对象时，不要显式调用对象的toString()
         * 如下，+实际是StringBuilder，本身会调用对象的toString()，且能很好的处理null的情况。
         */
        MyObject myObject = null;
        //WRONG
        str = "result:" + myObject.toString();  // myObject为Null时，抛NPE

        //RIGHT
        str = "result:" + myObject;  // myObject为Null时，输出 result:null
        /*-------------------------------------------------------------------------------------*/

        /*
         * 使用StringBuilder，而不是有所有方法都有同步修饰符的StringBuffer
         *
         * 因为内联不成功，逃逸分析并不能抹除StringBuffer上的同步修饰符
         *
         * 当拼接后字符串的长度远大于16时，指定StringBuilder的大概长度，避免容量不足时的成倍扩展
         *
         * 如果字符串长度很大且频繁拼接，可考虑ThreadLocal重用StringBuilder对象
         *
         *  参考BigDecimal的toString()实现，及vjkit中的StringBuilderHolder。
         */


        /*-------------------------------------------------------------------------------------*/
        /*
         *字符操作时，优先使用字符参数，而不是字符串，能提升性能
         *
         * 其他包括split等方法，在JDK String中未提供针对字符参数的方法，可考虑使用Apache Commons StringUtils 或Guava的Splitter。
         */

        //WRONG
        str.indexOf("e");

        //RIGHT
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append('a');
        str.indexOf('e');
        str.replace('m','z');

    }
    static class MyObject{
        public MyObject(int id, String name) {
            this.id = id;
            this.name = name;
        }

        private int id ;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "MyObject{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}

