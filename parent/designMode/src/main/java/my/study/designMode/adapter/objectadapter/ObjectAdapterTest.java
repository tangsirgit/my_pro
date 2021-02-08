package my.study.designMode.adapter.objectadapter;

/**
 * 对象适配模式-测试类
 *
 * @author : tanghuai
 * @date : 2021/2/8 14:10
 */
public class ObjectAdapterTest {
    public static void main(String[] args) {
        OldObjectClass oldObjectClass = new OldObjectClass();
        NewObjectClass newObjectClass = new NewObjectClass(oldObjectClass);
        newObjectClass.method1();
        newObjectClass.method2();
    }
}
