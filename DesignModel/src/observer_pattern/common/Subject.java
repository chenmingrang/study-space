package observer_pattern.common;

import java.util.Vector;

/**
 * Created by cmr on 2018/1/9.
 */
public abstract class Subject {
    private Vector<Observer> observers = new Vector<>();

    public void addObsever(Observer _observer){
        this.observers.add(_observer);
    }

    public void remove(Observer _observer){
        this.observers.remove(_observer);
    }

    public void notifyObserver(){
        for(Observer observer : observers){
            observer.update();
        }
    }
}
