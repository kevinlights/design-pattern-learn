package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class ConcreteSubject extends Subject {
    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
