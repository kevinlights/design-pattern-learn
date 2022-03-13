package sample.log;

import dp.utils.FileUtil;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) {
        ConfigSettingWindow csw = new ConfigSettingWindow(); // 请求发送者
        Command command; // 命令对象
        ConfigOperator co = new ConfigOperator(); // 请求接收者

        command = new InsertCommand("增加");
        command.setConfigOperator(co);
        csw.setCommand(command);
        csw.call("网站首页");

        command = new InsertCommand("增加");
        command.setConfigOperator(co);
        csw.setCommand(command);
        csw.call("端口号");

        command = new ModifyCommand("修改");
        command.setConfigOperator(co);
        csw.setCommand(command);
        csw.call("网站首页");

        command = new ModifyCommand("修改");
        command.setConfigOperator(co);
        csw.setCommand(command);
        csw.call("端口号");

        System.out.println("----------------------------");
        System.out.println("保存配置");
        csw.save();

        System.out.println("----------------------------");
        System.out.println("恢复配置");
        System.out.println("----------------------------");
        csw.recover();
    }
}

class ConfigSettingWindow {
    private List<Command> commands = new ArrayList<>();
    private Command command;
    private final String redoFile = "redo.log";

    public void setCommand(Command command) {
        this.command = command;
    }

    // 执行配置文件修改命令，同时将命令对象添加到命令集合中
    public void call(String args) {
        command.execute(args);
        commands.add(command);
    }

    // 记录请求日志，生成日志文件，将命令集合写入日志文件
    public void save() {
        FileUtil.writeObject(commands, redoFile);
    }

    // 从日志文件中提取命令集合，并循环调用每一个命令对象的 execute 方法来实现配置文件的重新配置
    public void recover() {
        List<?> commands = (List<?>) FileUtil.readObject(redoFile);
        if (null == commands) {
            return;
        }
        for (Object obj : commands) {
            ((Command) obj).execute();
        }
    }
}

public abstract class Command implements Serializable {
    protected String name;
    protected String args;
    protected ConfigOperator configOperator;

    public Command(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setConfigOperator(ConfigOperator configOperator) {
        this.configOperator = configOperator;
    }

    public abstract void execute(String args);
    public abstract void execute();
}


class InsertCommand extends Command {
    public InsertCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        configOperator.insert(args);
    }

    @Override
    public void execute() {
        configOperator.insert(this.args);
    }
}

class ModifyCommand extends Command {

    public ModifyCommand(String name) {
        super(name);
    }

    @Override
    public void execute(String args) {
        this.args = args;
        configOperator.modify(args);
    }

    @Override
    public void execute() {
        configOperator.modify(this.args);
    }
}



class ConfigOperator implements Serializable {
    public void insert(String args) {
        System.out.println("增加新节点：" + args);
    }

    public void modify(String args) {
        System.out.println("修改节点：" + args);
    }

    public void delete(String args) {
        System.out.println("删除节点：" + args);
    }
}