package my.study.designMode.adapter.classadapter;

/**
 * @author : tanghuai
 * @date : 2021/2/8 11:51
 */
public class NewAdapterClass extends OldAdapterClass implements AdapterInterface {
    @Override
    public void method2() {
        System.out.println("方法2");
    }
}
