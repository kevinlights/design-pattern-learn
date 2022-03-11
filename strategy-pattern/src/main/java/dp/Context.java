package dp;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void algorithm() {
        this.strategy.algorithm();
    }
}
