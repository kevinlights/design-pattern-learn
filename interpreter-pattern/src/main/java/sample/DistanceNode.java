package sample;

/**
 * created on 2022/3/12
 * 距离解释，终结符表达式
 * @author kevinlights
 */
public class DistanceNode extends AbstractNode {
    private String distance;

    public DistanceNode(String distance) {
        this.distance = distance;
    }

    @Override
    public String interpret() {
        return this.distance;
    }
}
