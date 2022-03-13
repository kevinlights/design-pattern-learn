package sample;

import dp.utils.BeanUtil;
import dp.utils.XmlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        FBSettingWindow fbsw = new FBSettingWindow("功能键设置");
        FunctionButton fb1, fb2;
        fb1 = new FunctionButton("功能键1");
        fb2 = new FunctionButton("功能键2");
        Command command1, command2;
        command1 = (Command) Class.forName(XmlUtil.getL1Value("config.xml", "command1")).newInstance();
        command2 = (Command) Class.forName(XmlUtil.getL1Value("config.xml", "command2")).newInstance();


        // 将命令对象注入功能键对象
        fb1.setCommand(command1);
        fb2.setCommand(command2);

        fbsw.addFunctionButton(fb1).addFunctionButton(fb2);

        fbsw.display();

        // 调用功能键的业务方法
        fb1.onClick();
        fb2.onClick();
    }
}

class FBSettingWindow {
    private String title;
    private List<FunctionButton> functionButtonList = new ArrayList<>();

    public FBSettingWindow(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public FBSettingWindow addFunctionButton(FunctionButton fb) {
        functionButtonList.add(fb);
        return this;
    }

    public void removeFunctionButton(FunctionButton fb) {
        functionButtonList.remove(fb);
    }

    public void display() {
        System.out.println("显示窗口：" + this.title);
        System.out.println("显示功能键：");
        for (FunctionButton fb : functionButtonList) {
            System.out.println(fb.getName());
        }
        System.out.println("------------------------------");
    }
}

public abstract class Command {
    public abstract void execute();
}

class FunctionButton {
    private String name;
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public FunctionButton(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void onClick() {
        System.out.print("点击功能键：");
        command.execute();
    }
}

class MinimizeCommand extends Command {
    private WindowHandler handler;

    public MinimizeCommand() {
        this.handler = new WindowHandler();
    }

    @Override
    public void execute() {
        handler.minimize();
    }
}

class HelpCommand extends Command {
    private HelpHandler handler;

    public HelpCommand() {
        handler = new HelpHandler();
    }

    @Override
    public void execute() {
        handler.display();
    }
}

class WindowHandler {
    public void minimize() {
        System.out.println("将窗口最小化至托盘！");
    }
}

class HelpHandler {
    public void display() {
        System.out.println("显示帮助文档！");
    }
}
