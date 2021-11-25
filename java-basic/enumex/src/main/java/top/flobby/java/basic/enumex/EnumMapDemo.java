package top.flobby.java.basic.enumex;

import java.util.*;

/**
 * @author : Flobby
 * @program : java-basic
 * @description : 分析EnumMap & HashMap
 * @create : 2021-11-25 14:04
 **/

public class EnumMapDemo {
    public static void main(String[] args) {
        List<StudyJava> list = new ArrayList<>();
        list.add(new StudyJava("January", ProjectEnum.SSH));
        list.add(new StudyJava("February", ProjectEnum.SSM));
        list.add(new StudyJava("March", ProjectEnum.SSM));
        list.add(new StudyJava("April", ProjectEnum.SPRINGBOOT));
        list.add(new StudyJava("May", ProjectEnum.SPRINGBOOT));
        list.add(new StudyJava("June", ProjectEnum.SPRINGCLOUD));
        // 1.使用hashmap
        Map<ProjectEnum, Integer> hashmap = new HashMap<>();
        list.stream().map(StudyJava::getProjectEnum).forEach(projectEnum -> {
            hashmap.merge(projectEnum, 1, Integer::sum);
        });
        System.out.println(hashmap);
        System.out.println("=======================================");
        // 2.使用EnumMap
        Map<ProjectEnum, Integer> enumMap = new EnumMap(ProjectEnum.class);
        for (StudyJava s :
                list) {
            ProjectEnum projectEnum = s.getProjectEnum();
            enumMap.merge(projectEnum, 1, Integer::sum);
        }
        System.out.println(enumMap);
    }
}


enum ProjectEnum {
    /**
     * 枚举
     */
    SSM,
    SSH,
    SPRINGBOOT,
    SPRINGCLOUD;
}

class StudyJava {
    private String month;
    private ProjectEnum projectEnum;

    public StudyJava(String month, ProjectEnum projectEnum) {
        this.month = month;
        this.projectEnum = projectEnum;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public ProjectEnum getProjectEnum() {
        return projectEnum;
    }

    public void setProjectEnum(ProjectEnum projectEnum) {
        this.projectEnum = projectEnum;
    }
}