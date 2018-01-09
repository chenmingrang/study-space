package observer_pattern.java_api;

import java.util.Observable;

/**
 * Created by cmr on 2018/1/9.
 */
public class ConcreteSubject extends Observable implements Subject {
    @Override
    public void doSomething() {
        System.out.println("subject: subject is doing something...");
        super.setChanged();
        super.notifyObservers();
    }
}
