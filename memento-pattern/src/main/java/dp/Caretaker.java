package dp;

/**
 * created on 2022/3/12
 * 负责人，又称为管理者，它负责保存备忘录，但不能对备忘录的内容进行操作或检查。
 * 可存储一个或多个备忘录对象，不能修改对象，也无须知道对象的实现细节
 * @author kevinlights
 */
public class Caretaker {
    private Memento memento;

    public Memento getMemento() {
        return memento;
    }

    public void setMemento(Memento memento) {
        this.memento = memento;
    }
}
