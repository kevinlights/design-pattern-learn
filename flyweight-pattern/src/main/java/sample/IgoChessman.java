package sample;

import java.util.Hashtable;

/**
 * created on 2022/3/13
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) {
        IgoChessman black1, black2, black3, white1, white2;

        IgoChessmanFactory factory = IgoChessmanFactory.getInstance();

        //通过享元工厂获取三颗黑子
        black1 = factory.getIgoChessman("b");
        black2 = factory.getIgoChessman("b");
        black3 = factory.getIgoChessman("b");

        System.out.println("判断两颗黑子是否相同：" + (black1 == black2));

        //通过享元工厂获取两颗白子
        white1 = factory.getIgoChessman("w");
        white2 = factory.getIgoChessman("w");
        System.out.println("判断两颗白子是否相同：" + (white1 == white2));

        //显示棋子
        black1.display();
        black2.display();
        black3.display();
        white1.display();
        white2.display();
    }
}

class IgoChessmanFactory {
    // 单例
    private static IgoChessmanFactory instance = new IgoChessmanFactory();
    private static Hashtable<String, IgoChessman> ht; // 存储享元对象，充当享元池

    private IgoChessmanFactory() {
        ht = new Hashtable<>();
        IgoChessman black, white;
        black = new BlackIgoChessman();
        ht.put("b", black);
        white = new WhiteIgoChessMan();
        ht.put("w", white);
    }

    public static IgoChessmanFactory getInstance() {
        return instance;
    }

    public IgoChessman getIgoChessman(String color) {
        // 实际取到的对象是唯一确定的，在 private 的构造方法中已经全部实例化出来
        return ht.get(color);
    }
}

public abstract class IgoChessman {
    public abstract String getColor();

    public void display() {
        System.out.println("棋子颜色：" + this.getColor());
    }
}

class BlackIgoChessman extends IgoChessman {

    @Override
    public String getColor() {
        return "黑色";
    }
}

class WhiteIgoChessMan extends IgoChessman {

    @Override
    public String getColor() {
        return "白色";
    }
}


