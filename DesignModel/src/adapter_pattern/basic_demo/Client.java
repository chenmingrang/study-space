package adapter_pattern.basic_demo;

/**
 * Created by cmr on 2017/12/14.
 */
public class Client {
    public static void main(String[] args){
        Target target = new ConcreteTarget();
        target.request();

        Target target2 = new Adapter();
        target2.request();
    }
}
