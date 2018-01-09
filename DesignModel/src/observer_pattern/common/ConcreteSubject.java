package observer_pattern.common;

/**
 * Created by cmr on 2018/1/9.
 */
public class ConcreteSubject extends Subject{
    public void doSomething(){
        System.out.println("Subject is doing something!");
        super.notifyObserver();
    }
}
