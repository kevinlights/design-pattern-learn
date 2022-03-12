package sample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
class ClientV2 {
    // 记录当前状态所在位置，方便撤消或重做
    private static int index = -1;
    private static MementoCaretakerV2 mc = new MementoCaretakerV2();

    public static void main(String[] args) {
        Chessman chess = new Chessman("车",1,1);
        play(chess);
        chess.setY(4);
        play(chess);
        chess.setX(5);
        play(chess);
        undo(chess, index);
        undo(chess, index);
        redo(chess, index);
        redo(chess, index);
        // redo(chess, index);
    }

    public static void play(Chessman chess) {
        // 保存备忘录
        mc.setMemento(chess.save());
        index++;
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }

    public static void undo(Chessman chess, int i) {
        System.out.println("******悔棋******");
        index--;
        chess.restore(mc.getMemento(i - 1));
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }

    public static void redo(Chessman chess, int i) {
        System.out.println("******撤销悔棋******");
        index++;
        chess.restore(mc.getMemento(i + 1));
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }
}

class Client {
    public static void main(String[] args) {
        MementoCaretaker mc = new MementoCaretaker();

        Chessman chess = new Chessman("车",1,1);
        display(chess);

        mc.setMemento(chess.save()); // 保存状态

        // 操作
        chess.setY(4);
        display(chess);

        mc.setMemento(chess.save()); // 保存状态

        display(chess);

        // 继续操作
        chess.setX(5);
        display(chess);

        System.out.println("******悔棋******");

        chess.restore(mc.getMemento());

        display(chess);
    }

    public static void display(Chessman chess) {
        System.out.println("棋子" + chess.getLabel() + "当前位置为：" + "第" + chess.getX() + "行" + "第" + chess.getY() + "列。");
    }
}


@Getter
@Setter
@AllArgsConstructor
class Chessman {
    // 象棋棋子类，原发器
    private String label;
    private int x;
    private int y;

    public ChessmanMemento save() {
        // 保存状态
        return new ChessmanMemento(label, x, y);
    }

    public void restore(ChessmanMemento memento) {
        this.label = memento.getLabel();
        this.x = memento.getX();
        this.y = memento.getY();
    }
}

@Getter
@Setter
@AllArgsConstructor
public class ChessmanMemento {
    private String label;
    private int x;
    private int y;
}

@Getter
@Setter
class MementoCaretaker {
    private ChessmanMemento memento;
}

@Getter
@Setter
class MementoCaretakerV2 {
    // 负责人中只有一个备忘录对象，因此只能撤消一步操作
    // private ChessmanMemento memento;

    // 使用 ArrayList 来存储多个备忘录
    private ArrayList<ChessmanMemento> mementoList = new ArrayList<>();

    public ChessmanMemento getMemento(int i) {
        return mementoList.get(i);
    }

    public void setMemento(ChessmanMemento memento) {
        mementoList.add(memento);
    }
}
