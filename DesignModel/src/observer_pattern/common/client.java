package observer_pattern.common;

/**
 * Created by cmr on 2018/1/9.
 */
public class client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        ConcreteObserver observer = new ConcreteObserver();
        subject.addObsever(observer);
        subject.doSomething();
    }
}
