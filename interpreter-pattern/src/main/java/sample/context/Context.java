package sample.context;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * created on 2022/3/12
 * <p>
 * LOOP 2 PRINT杨过 SPACE SPACE PRINT 小龙女 BREAK END PRINT郭靖 SPACE SPACE PRINT 黄蓉
 * <p>
 * expression ::= command* //表达式，一个表达式包含多条命令
 * command ::= loop | primitive //语句命令
 * loop ::= 'loopnumber' expression  'end' //循环命令，其中number为自然数
 * primitive ::= 'printstring'  | 'space' | 'break' //基本命令，其中string为字符串
 *
 * @author kevinlights
 */

class Client {
    public static void main(String[] args) {
        String text = "LOOP 2 PRINT 杨过 SPACE SPACE PRINT 小龙女 BREAK END PRINT 郭靖 SPACE SPACE PRINT 黄蓉";
        Context context = new Context(text);
        Node node = new ExpressionNode();
        node.interpret(context);
        node.execute();
    }
}

public class Context {
    private StringTokenizer tokenizer; // 以空格分词
    private String currentToken;

    public Context(String text) {
        tokenizer = new StringTokenizer(text);
        nextToken();
    }

    public String nextToken() {
        if (tokenizer.hasMoreTokens()) {
            currentToken = tokenizer.nextToken();
        } else {
            currentToken = null;
        }
        return currentToken;
    }

    public String getCurrentToken() {
        return currentToken;
    }

    public void skipToken(String token) {
        if (!token.equals(currentToken)) {
            System.err.println("错误提示：" + currentToken + "解释错误！");
        }
        nextToken();
    }

    public int currentNumber() {
        int number = 0;
        try {
            number = Integer.parseInt(currentToken);
        } catch (NumberFormatException e) {
            System.err.println("错误提示：" + e);
        }
        return number;
    }

}

abstract class Node {
    public abstract void interpret(Context context);

    public abstract void execute();
}

// 语句命令节点类，非终结符表达式
class CommandNode extends Node {
    private Node node;

    @Override
    public void interpret(Context context) {
        if (context.getCurrentToken().equals("LOOP")) {
            // LOOP 命令
            node = new LoopCommandNode();
            node.interpret(context);
        } else {
            // 其他基本命令
            node = new PrimitiveCommandNode();
            node.interpret(context);
        }
    }

    @Override
    public void execute() {
        node.execute();
    }
}



// 表达式节点类，非终结符表达式
class ExpressionNode extends Node {
    // 定义集合存储多条命令
    private final List<Node> list = new ArrayList<>();

    @Override
    public void interpret(Context context) {
        while (true) {
            if (context.getCurrentToken() == null) {
                break;
            } else if (context.getCurrentToken().equals("END")) {
                context.skipToken("END");
                break;
            } else {
                Node commandNode = new CommandNode();
                commandNode.interpret(context);
                list.add(commandNode);
            }
        }
    }

    @Override
    public void execute() {
        for (Node node : list) {
            node.execute();
        }
    }
}

// 循环命令节点类，非终结符表达式
class LoopCommandNode extends Node {
    private int number; // 循环次数
    private Node commandNode; // 循环语句中的表达式

    @Override
    public void interpret(Context context) {
        context.skipToken("LOOP");
        number = context.currentNumber();
        context.nextToken();
        commandNode = new ExpressionNode(); // 循环语句中的表达式
        commandNode.interpret(context);
    }

    @Override
    public void execute() {
        for (int i = 0; i < number; i++) {
            commandNode.execute();
        }
    }
}

// 基本命令节点类，终结符表达式
class PrimitiveCommandNode extends Node {
    private String name;
    private String text;


    @Override
    public void interpret(Context context) {
        name = context.getCurrentToken();
        context.skipToken(name);
        if (!name.equals("PRINT") && !name.equals("BREAK") && !name.equals("SPACE")) {
            System.err.println("非法命令！");
        }
        if (name.equals("PRINT")) {
            text = context.getCurrentToken();
            context.nextToken();
        }
    }

    @Override
    public void execute() {
        if (name.equals("PRINT")) {
            System.out.print(text);
        } else if (name.equals("SPACE")) {
            System.out.print(" ");
        } else if (name.equals("BREAK")) {
            System.out.println();
        }
    }
}

