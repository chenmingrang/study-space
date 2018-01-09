package observer_pattern.common;

/**
 * Created by cmr on 2018/1/9.
 */
public class ConcreteObserver implements Observer {
    @Override
    public void update() {
        System.out.println("observer 接收到消息，并进行处理!");
    }
}
