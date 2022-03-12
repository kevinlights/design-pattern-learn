package sample;

import java.util.Stack;

/**
 * created on 2022/3/12
 * 指令处理类
 *
 * expression ::= direction action distance | composite //表达式
 * composite ::= expression 'and' expression //复合表达式
 * direction ::= 'up' | 'down' | 'left' | 'right' //移动方向
 * action ::= 'move' | 'run' //移动方式
 * distance ::= an integer //移动距离
 *
 * @author kevinlights
 */
public class InstructionHandler {
    private String instruction;
    private AbstractNode node;

    public void handle(String instruction) {
        AbstractNode left, right, direction, action, distance;

        // 声明一个栈对象用于存储抽象语法树 AST
        Stack<AbstractNode> stack = new Stack<>();

        // 以空格分隔指令字符串
        String[] words = instruction.split(" ");

        for (int i = 0; i < words.length; i++) {
            // 采用栈来处理指令，遇到  and 则将其后的三个单词作为三个终结符表达式连成一个句子 SentenceNode
            // 作为 and 的右表达式，而将从栈顶弹出的表达式作为 and 的左表达式
            // 最后将新的 and 表达式压入栈中
            if ("and".equalsIgnoreCase(words[i])) {
                left = stack.pop();
                direction = new DirectionNode(words[++i]);
                action = new ActionNode(words[++i]);
                distance = new DistanceNode(words[++i]);
                right = new SentenceNode(direction, action, distance);
                // 将新表达式压入栈中
                stack.push(new AndNode(left, right));
            } else {
                // 如果是从头开始进行解释，则将前三个单词组成一个简单句子 SentenceNode
                // 并将该句子压入栈中
                direction = new DirectionNode(words[i]);
                action = new ActionNode(words[++i]);
                distance = new DistanceNode(words[++i]);
                left = new SentenceNode(direction, action, distance);
                stack.push(left);
            }
        }
        // 将全部表达式从栈中弹出
        this.node = stack.pop();
    }

    public String output() {
        return node.interpret();
    }
}
