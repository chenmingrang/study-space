package observer_pattern.java_api;

/**
 * Created by cmr on 2018/1/9.
 */
public class client {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        MyObserver observer = new MyObserver();

        subject.addObserver(observer);
        subject.doSomething();
    }
}
