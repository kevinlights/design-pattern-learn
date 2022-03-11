package sample;

import dp.utils.XmlUtil;

/**
 * created on 2022/3/12
 *
 * @author kevinlights
 */
class Client {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        Account account = (Account) Class.forName(XmlUtil.getL1Value("config.xml", "className")).newInstance();
        account.handle("admin", "admin");
    }
}

public abstract class Account {
    public boolean validate(String account, String password) {
        System.out.println("account: " + account);
        System.out.println("password: " + password);
        if (account.equals("admin") && password.equals("admin")) {
            return true;
        }
        return false;
    }

    abstract void calculateInterest();

    public void display() {
        System.out.println("display interest");
    }

    public void handle(String account, String password) {
        if (!validate(account, password)) {
            System.out.println("account or password invalid");
            return;
        }
        calculateInterest();
        display();
    }
}

class CurrentAccount extends Account {

    @Override
    void calculateInterest() {
        System.out.println("CurrentAccount -> calculateInterest");
    }
}

class SavingAccount extends Account {

    @Override
    void calculateInterest() {
        System.out.println("SavingAccount -> calculateInterest");
    }
}
