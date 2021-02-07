package my.study.designMode.prototypemode;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;


/**
 * @author : tanghuai
 * @date : 2021/2/7 11:11
 */
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class Sheep implements Cloneable {
    private String name;
    private int age;
    private Cow cow;

    public static Logger getLog() {
        return log;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Sheep sheep = null;
        try {
            sheep = (Sheep) super.clone();
        } catch (Exception e) {
            log.error("clone出错", e);
        }
        return sheep;
    }

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

    public Cow getCow() {
        return cow;
    }

    public void setCow(Cow cow) {
        this.cow = cow;
    }

    @Override
    public String toString() {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
