package top.flobby.java.basic.enumex;

/**
 * @author : JinChenXing
 * @program : java-basic
 * @description : 枚举类
 * @create : 2021-11-25 12:59
 **/

public enum Weekday {
    /**
     * 枚举值
     */
    SUNDAY(0),
    MONDAY(1),
    TUESDAY(2),
    WEDNESDAY(3),
    THURSDAY(4),
    FRIDAY(5),
    SATURDAY(6);

    private final int value;

    Weekday(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
