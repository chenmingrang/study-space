package adapter_pattern.basic_demo;

/**
 * Created by cmr on 2017/12/14.
 * 目标角色的实现类
 */
public class ConcreteTarget implements Target {

    @Override
    public void request() {
        System.out.println("if you need any help, please call me!");
    }
}
