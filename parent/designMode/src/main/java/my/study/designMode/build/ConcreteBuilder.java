package my.study.designMode.build;

/**
 * @author : tanghuai
 * @date : 2021/2/7 15:28
 */
public class ConcreteBuilder extends Builder {
    Computer computer = new Computer();

    @Override
    public void buildCPU() {
        computer.Add("装CPU");
    }

    @Override
    public void buildMainBoard() {
        computer.Add("装主板");
    }

    @Override
    public void buildHD() {
        computer.Add("装硬盘");
    }

    @Override
    public Computer getComputer() {
        return computer;
    }
}
