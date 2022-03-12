package sample;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
class ScreenClient {
    public static void main(String[] args) {
        Screen screen = new Screen();
        screen.onClick();
        screen.onClick();
        screen.onClick();
    }
}

class Screen {
    private ScreenState currentState, normalState, largerState, largestState;

    public Screen() {
        this.normalState = new NormalScreenState();
        this.largerState = new LargerScreenState();
        this.largestState = new LargestScreenState();
        this.currentState = normalState;
        this.currentState.display();
    }

    public void setState(ScreenState state) {
        this.currentState = state;
    }

    public void onClick() {
        if (this.currentState == normalState) {
            this.setState(largerState);
        } else if (this.currentState == largerState) {
            this.setState(largestState);
        } else if (this.currentState == largestState) {
            this.setState(normalState);
        }
        this.currentState.display();
    }
}

public abstract class ScreenState {
    abstract void display();
}

class NormalScreenState extends ScreenState {
    @Override
    void display() {
        System.out.println("正常大小！");
    }
}

class LargerScreenState extends ScreenState {
    @Override
    void display() {
        System.out.println("二倍大小！");
    }
}

class LargestScreenState extends ScreenState {
    @Override
    void display() {
        System.out.println("四倍大小！");
    }
}
