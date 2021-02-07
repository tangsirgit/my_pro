package my.study.designMode.single;

/**
 * 单列模式之饿汉模式
 *
 * @author : tanghuai
 * @date : 2021/2/7 13:53
 */
public class SingletonOne {
    private static SingletonOne singletonOne = new SingletonOne();

    /**
     * 私有构造方法
     */
    private SingletonOne() {
    }

    public static SingletonOne getInstance() {
        return singletonOne;
    }
}
