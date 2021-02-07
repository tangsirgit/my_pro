package my.study.designMode.factory;

interface Sender {
    /**
     * 发送方式
     */
    void send();
}

/**
 * 单个工厂模式
 *
 * @author : tanghuai
 * @date : 2021/2/7 14:52
 */

public class FactoryPattern {
    public static void main(String[] args) {
        Sender sender = produce("mail");
        sender.send();
    }

    public static Sender produce(String str) {
        if ("mail".equals(str)) {
            return new MailSender();
        } else if ("Sms".equals(str)) {
            return new SmsSender();
        } else {
            System.out.println("输入错误");
            return null;
        }
    }
}

class MailSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is email");
    }
}

class SmsSender implements Sender {

    @Override
    public void send() {
        System.out.println("this is sms");
    }
}




