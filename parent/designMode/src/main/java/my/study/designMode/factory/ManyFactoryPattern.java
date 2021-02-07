package my.study.designMode.factory;

/**
 * 多个工厂模式
 *
 * @author : tanghuai
 * @date : 2021/2/7 14:52
 */

interface ManySender {
    void Send();
}

class ManyMailSender implements ManySender {

    @Override
    public void Send() {
        System.out.println("This is mail sender...");
    }
}

class ManySmsSender implements ManySender {

    @Override
    public void Send() {
        System.out.println("This is sms sender...");
    }
}

class SendFactory {
    public Sender produceMail() {
        return new MailSender();
    }

    public Sender produceSms() {
        return new SmsSender();
    }
}

public class ManyFactoryPattern {
    public static void main(String[] args) {
        SendFactory factory = new SendFactory();
        Sender sender = factory.produceMail();
        sender.send();
    }
}



