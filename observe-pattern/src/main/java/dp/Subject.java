package dp;

import java.util.ArrayList;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public abstract class Subject {
    protected ArrayList<Observer> observers = new ArrayList<>();

    public void attach(Observer observer) {
        observers.add(observer);
    }

    public void detach(Observer observer) {
        observers.remove(observer);
    }

    public abstract void notifyObservers();
}
