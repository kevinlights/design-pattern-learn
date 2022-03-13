package dp;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
public class ConcreteHandler extends Handler {

    @Override
    public void handleRequest(String request) {
        if (1==1) {
            // handler request
        } else {
            this.successor.handleRequest(request);
        }
    }
}
