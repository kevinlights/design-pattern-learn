package sample;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
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
