package my.study.designMode.single;

/**
 * 单列模式之懒汉模式
 *
 * @author : tanghuai
 * @date : 2021/2/7 13:55
 */
public class SingletonTwo {
    private static SingletonTwo singletonTwo = null;

    /**
     * 私有构造方法
     */
    private SingletonTwo() {
    }

    public static SingletonTwo getInstance() {
        // 双重检验锁
        if (singletonTwo == null) {
            synchronized (SingletonTwo.class) {
                if (singletonTwo == null) {
                    singletonTwo = new SingletonTwo();
                }
            }
        }
        return singletonTwo;
    }
}
