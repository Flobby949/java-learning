package top.flobby.java.basic.enumex;

/**
 * @author : JinChenXing
 * @program : java-basic
 * @description :
 * @create : 2021-11-25 13:45
 **/

public enum Season {
    /**
     * 枚举定义
     */
    SPRING("1") {
        @Override
        public Season getNextSeason() {
            return SUMMER;
        }
    },
    SUMMER("4") {
        @Override
        public Season getNextSeason() {
            return AUTUMN;
        }
    },
    AUTUMN("7") {
        @Override
        public Season getNextSeason() {
            return WINTER;
        }
    },
    WINTER("10") {
        @Override
        public Season getNextSeason() {
            return SPRING;
        }
    };

    private final String monthStart;

    Season(String monthStart) {
        this.monthStart = monthStart;
    }

    public abstract Season getNextSeason();

    public String getMonthStart() {
        return monthStart;
    }
}

class SeasonTest {
    public static void main(String[] args) {
        System.out.println("SPRING下一个季节是：" + Season.SPRING.getNextSeason());
    }
}
