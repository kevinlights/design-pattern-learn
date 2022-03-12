package sample;

import java.util.ArrayList;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) {
        AllyControlCenter acc = new ConcreteAllyControlCenter("金庸群侠");

        Observer player1, player2, player3, player4;

        player1 = new Player("杨过");
        acc.join(player1);
        player2 = new Player("令狐冲");
        acc.join(player2);
        player3 = new Player("张无忌");
        acc.join(player3);
        player4 = new Player("段誉");
        acc.join(player4);

        player1.beAttacked(acc);
    }
}

public interface Observer {
    public String getName();

    public void setName(String name);

    public void help();

    public void beAttacked(AllyControlCenter acc);
}

abstract class AllyControlCenter {
    protected String allyName;
    protected ArrayList<Observer> players = new ArrayList<>();

    public String getAllyName() {
        return allyName;
    }

    public void setAllyName(String allyName) {
        this.allyName = allyName;
    }

    public void join(Observer obs) {
        System.out.println(obs.getName() + "加入" + this.allyName + "战队！");
        players.add(obs);
    }

    public void quit(Observer obs) {
        System.out.println(obs.getName() + "退出" + this.allyName + "战队！");
        players.remove(obs);
    }

    public abstract void notifyObserver(String name);
}

class Player implements Observer {
    private String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void help() {
        System.out.println("坚持住，" + this.name + "来救你！");
    }

    @Override
    public void beAttacked(AllyControlCenter acc) {
        System.out.println(this.name + "被攻击！");
        acc.notifyObserver(this.name);
    }
}

class ConcreteAllyControlCenter extends AllyControlCenter {
    public ConcreteAllyControlCenter(String allyName) {
        System.out.println(allyName + "战队组建成功！");
        System.out.println("----------------------------");
        this.allyName = allyName;
    }

    @Override
    public void notifyObserver(String name) {
        System.out.println(this.allyName + "战队紧急通知，盟友" + name + "遭受敌人攻击！");
        for (Observer obs : players) {
            if (obs.getName().equalsIgnoreCase(name)) {
                obs.help();
            }
        }
    }
}