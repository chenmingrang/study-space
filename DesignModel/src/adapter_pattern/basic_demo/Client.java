package adapter_pattern.basic_demo;

/**
 * Created by cmr on 2017/12/14.
 */
public class Client {
    public static void main(String[] args){
        //原有业务逻辑
        Target target = new ConcreteTarget();
        target.request();

        //增加适配器后的业务逻辑
        Target target2 = new Adapter();
        target2.request();
    }
}
