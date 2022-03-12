package dp.share;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
public class OnState extends State {
    @Override
    void on(Switch s) {
        System.out.println("已经打开！");
    }

    @Override
    void off(Switch s) {
        System.out.println("关闭！");
        s.setState(Switch.getState("off"));
    }
}
