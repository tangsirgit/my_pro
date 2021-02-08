package my.study.designMode.adapter.interfaceadapter;

/**
 * 接口适配模式测试
 *
 * @author : tanghuai
 * @date : 2021/2/8 14:20
 */
public class InterfaceAdapterTest {
    public static void main(String[] args) {
        SSHClass sshClass = new SSHClass();
        NetClass netClass = new NetClass();
        sshClass.ssh();
        netClass.net();
    }
}
