package adapter_pattern.basic_demo;

/**
 * Created by cmr on 2017/12/14.
 * 核心角色，适配器
 */
public class Adapter extends Adaptee implements Target{
    @Override
    public void request() {
        super.doSomething();
    }
}
