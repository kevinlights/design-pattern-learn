package sample;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) {
        // 中介者
        ConcreteMediator mediator = new ConcreteMediator();

        //定义同事对象
        Button addBT = new Button();
        List list = new List();
        ComboBox cb = new ComboBox();
        TextBox userNameTB = new TextBox();

        // 同事对象关联中介者
        addBT.setMediator(mediator);
        list.setMediator(mediator);
        cb.setMediator(mediator);
        userNameTB.setMediator(mediator);

        // 中介对象关联同事对象
        mediator.addButton = addBT;
        mediator.list = list;
        mediator.cb = cb;
        mediator.userNameTextBox = userNameTB;

        // 同事对象更新
        addBT.changed();
        System.out.println("-----------------------------");
        list.changed();
    }
}

abstract class Component {
    protected Mediator mediator;

    public void setMediator(Mediator mediator) {
        this.mediator = mediator;
    }

    public void changed() {
        mediator.componentChanged(this);
    }

    public abstract void update();
}

public abstract class Mediator {
    public abstract void componentChanged(Component c);
}

class ConcreteMediator extends Mediator {
    public Button addButton;
    public List list;
    public TextBox userNameTextBox;
    public ComboBox cb;

    @Override
    public void componentChanged(Component c) {
        if (c == addButton) {
            System.out.println("--单击增加按钮--");
            list.update();
            cb.update();
            userNameTextBox.update();
        } else if (c == list) {
            System.out.println("--从列表框选择客户--");
            cb.select();
            userNameTextBox.setText();
        }//从组合框选择客户
        else if(c == cb) {
            System.out.println("--从组合框选择客户--");
            cb.select();
            userNameTextBox.setText();
        }
    }
}

class Button extends Component {

    @Override
    public void update() {
        // 按钮无交互
    }
}

class TextBox extends Component {

    @Override
    public void update() {
        System.out.println("客户信息增加成功后文本框清空。");
    }

    public void setText() {
        System.out.println("文本框显示：小龙女。");
    }
}

class List extends Component {

    @Override
    public void update() {
        System.out.println("列表框增加一项：张无忌。");
    }

    public void select() {
        System.out.println("列表框选中项：小龙女。");
    }
}

class ComboBox extends Component {

    @Override
    public void update() {
        System.out.println("组合框增加一项：张无忌。");
    }

    public void select() {
        System.out.println("组合框选中项：小龙女。");
    }
}
