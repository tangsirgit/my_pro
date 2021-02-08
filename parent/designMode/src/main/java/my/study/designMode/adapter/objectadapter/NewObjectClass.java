package my.study.designMode.adapter.objectadapter;

/**
 * 对象适配模式-新类
 *
 * @author : tanghuai
 * @date : 2021/2/8 13:31
 */
public class NewObjectClass implements ObjectInterface {

    private OldObjectClass objectClass;

    public NewObjectClass(OldObjectClass oldObjectClass) {
        this.objectClass = oldObjectClass;
    }

    @Override
    public void method1() {
        objectClass.method1();
    }

    @Override
    public void method2() {
        System.out.println("方法2");
    }
}
