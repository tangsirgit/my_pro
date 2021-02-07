package my.study.designMode.build;

/**
 * @author : tanghuai
 * @date : 2021/2/7 15:27
 */
public class BuilderPattern {
    public static void main(String[] args) {
        Director director = new Director();
        Builder builder = new ConcreteBuilder();
        director.Construct(builder);
        Computer computer = builder.getComputer();
        computer.print();
    }
}
