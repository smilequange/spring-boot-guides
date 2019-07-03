package cn.jantd.ioc.student.model;

/**
 * @Description
 * @Author  圈哥
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2019/7/3
 */
public class Student {
    /**
     * 名称
     */
    private  String name ;
    /**
     * 年龄
     */
    private  int age ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
