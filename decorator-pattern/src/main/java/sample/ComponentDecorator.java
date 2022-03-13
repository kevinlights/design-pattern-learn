package sample;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) {
        Component component, componentSB, componentBB;
        component = new Window();
        componentSB = new ScrollBarDecorator(component);
        componentBB = new BlackBorderDecorator(componentSB);
        // 调用装饰器的方法，从而实现装饰逻辑，再在装饰器内部调用实际组件逻辑
        componentBB.display();
    }
}

abstract class Component {
    abstract void display();
}

public class ComponentDecorator extends Component {
    private Component component;

    public ComponentDecorator(Component component) {
        this.component = component;
    }

    @Override
    void display() {
        component.display();
    }
}

class Window extends Component {
    @Override
    void display() {
        System.out.println("显示窗体！");
    }
}

//文本框类：具体构件类
class TextBox extends Component {
    public void display() {
        System.out.println("显示文本框！");
    }
}

//列表框类：具体构件类
class ListBox extends Component {
    public void display() {
        System.out.println("显示列表框！");
    }
}

class ScrollBarDecorator extends ComponentDecorator {
    @Override
    void display() {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar() {
        System.out.println("为构件增加滚动条！");
    }

    public ScrollBarDecorator(Component component) {
        super(component);
    }
}

//黑色边框装饰类：具体装饰类
class BlackBorderDecorator extends ComponentDecorator {
    public BlackBorderDecorator(Component component) {
        super(component);
    }

    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder() {
        System.out.println("为构件增加黑色边框！");
    }
}
