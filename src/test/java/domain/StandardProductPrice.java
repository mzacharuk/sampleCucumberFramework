package domain;

import utils.DatabaseUtil;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class StandardProductPrice implements ProductPrice{

    public String getPrice(String productName) {
        String url = "jdbc:mysql://localhost:3306/automationpractice";
        String user = "tester";
        String password = "tester";

        String price = "";
        DatabaseUtil databaseUtil = new DatabaseUtil(url, user, password);
        databaseUtil.openConnection();
        price = databaseUtil.executeQuery("SELECT `product_price` FROM `products` WHERE `name` = '" + productName + "'");
        databaseUtil.closeConnection();

        return price;
    }
}
