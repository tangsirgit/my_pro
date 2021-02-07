package my.study.designMode.prototypemode;

/**
 * 原型模式测试，浅拷贝（深拷贝，对象序列化，参考搜藏csdn）
 *
 * @author : tanghuai
 * @date : 2021/2/7 11:16
 */
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        Sheep sheepDolly = new Sheep("Dolly", 18, new Cow("niu", 21));
        Sheep sheep1 = (Sheep) sheepDolly.clone();
        Sheep sheep2 = (Sheep) sheepDolly.clone();
        Sheep sheep3 = (Sheep) sheepDolly.clone();
        System.out.println("sheep1:" + sheep1 + " ,hashcode:" + sheep1.hashCode() + " cowHashcode:" + sheep1.getCow().hashCode());
        System.out.println("sheep2:" + sheep2 + " ,hashcode:" + sheep2.hashCode() + " cowHashcode:" + sheep1.getCow().hashCode());
        System.out.println("sheep3:" + sheep3 + " ,hashcode:" + sheep3.hashCode() + " cowHashcode:" + sheep1.getCow().hashCode());
    }

}
