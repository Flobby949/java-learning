package top.flobby.java.basic.enumex;

/**
 * @author : Flobby
 * @program : java-basic
 * @description :
 * @create : 2021-11-25 13:52
 **/

public enum WeekStudy implements Study{
    /**
     * 枚举定义
     */
    SUNDAY(0, "星期日"),
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六");

    private int id;
    private String meaning;

    WeekStudy(int id, String meaning) {
        this.id = id;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return "WeekStudy{" +
                "id=" + id +
                ", meaning='" + meaning + '\'' +
                '}';
    }


    @Override
    public void studyJava() {
        System.out.println(this.meaning + "学习Java");
    }

    @Override
    public void studyDataStructure() {
        System.out.println(this.meaning + "学习数据结构");
    }

    @Override
    public void studyDesignMode() {
        System.out.println(this.meaning + "学习设计模式");
    }

    @Override
    public void studySpring() {
        System.out.println(this.meaning + "学习Spring框架");
    }
}
