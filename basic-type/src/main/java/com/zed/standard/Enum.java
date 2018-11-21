package com.zed.standard;

/**
 * 描述:
 * Enum
 *
 * @author zed
 * @since 2018-11-21 4:27 PM
 */
public class Enum {
    /*如果变量值仅有有限的可选值，用枚举类来定义常量
     * 尤其是变量还希望带有名称之外的延伸属性时，如下例：
     */

    //WRONG
    public String MONDAY = "MONDAY";
    public int MONDAY_SEQ = 1;

    //RIGHT
    public enum SeasonEnum {
        SPRING(1), SUMMER(2), AUTUMN(3), WINTER(4);
        int seq;
        SeasonEnum(int seq) { this.seq = seq; }
    }
    /*
     * 业务代码中不要依赖ordinary()函数进行业务运算，而是自定义数字属性，以免枚举值的增减调序造成影响。
     * 例外：永远不会有变化的枚举，比如上例的一年四季。
     */
}

