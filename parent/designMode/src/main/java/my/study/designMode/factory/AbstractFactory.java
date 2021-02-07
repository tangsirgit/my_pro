package my.study.designMode.factory;

interface produce {
    AbstractSender produce();
}


interface AbstractSender {
    void send();
}

/**
 * 抽象工厂
 *
 * @author : tanghuai
 * @date : 2021/2/7 15:10
 */
public class AbstractFactory {
}

class AbstractEmail implements AbstractSender {
    @Override
    public void send() {
        System.out.println("this is email");
    }
}

class AbstractSms implements AbstractSender {
    @Override
    public void send() {
        System.out.println("this is sms");
    }
}


class EmailFactory implements produce {
    @Override
    public AbstractSender produce() {
        return new AbstractEmail();
    }
}

class SmsFactory implements produce {
    @Override
    public AbstractSender produce() {
        return new AbstractSms();
    }
}