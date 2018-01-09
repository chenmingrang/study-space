package observer_pattern.java_api;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by cmr on 2018/1/9.
 */
public class MyObserver implements Observer {
    @Override
    public void update(Observable observable, Object obj) {
        System.out.println("observer: subject is doing something...");
        System.out.println("采取应对措施！");
    }
}
