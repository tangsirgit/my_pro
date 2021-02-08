package my.study.designMode.adapter.classadapter;

/**
 * 类适配模式测试
 *
 * @author : tanghuai
 * @date : 2021/2/8 13:21
 */
public class AdapterTest {
    public static void main(String[] args) {
        NewAdapterClass newClazz = new NewAdapterClass();
        newClazz.method1();
        newClazz.method2();
    }
}
