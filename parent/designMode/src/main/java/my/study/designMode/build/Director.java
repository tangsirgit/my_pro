package my.study.designMode.build;

/**
 * @author : tanghuai
 * @date : 2021/2/7 15:28
 */
public class Director {
    public void Construct(Builder builder) {
        builder.buildCPU();
        builder.buildMainBoard();
        builder.buildHD();
    }
}
