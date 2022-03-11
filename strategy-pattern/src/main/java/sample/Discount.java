package sample;

import dp.utils.XmlUtil;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) throws Exception {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("---------------------------------");

        Discount discount = (Discount) Class.forName(XmlUtil.getL1Value("config.xml", "className")).newInstance();
        mt.setDiscount(discount);

        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}

class MovieTicket {
    private double price;
    private Discount discount;

    public double getPrice() {
        return discount.calculate(price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}

interface Discount {
    public double calculate(double price);
}

//学生票折扣类：具体策略类
class StudentDiscount implements Discount {
    public double calculate(double price) {
        System.out.println("学生票：");
        return price * 0.8;
    }
}
//儿童票折扣类：具体策略类
class ChildrenDiscount implements Discount {
    public double calculate(double price) {
        System.out.println("儿童票：");
        return price - 10;
    }
}
//VIP会员票折扣类：具体策略类
class VIPDiscount implements Discount {
    public double calculate(double price) {
        System.out.println("VIP票：");
        System.out.println("增加积分！");
        return price * 0.5;
    }
}
