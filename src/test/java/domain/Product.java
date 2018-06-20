package domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by mzacharuk on 2017-06-20
 */
@Component
public class Product {

    private String productName;
    private String price;
    private int quantity;

    public String getProductName(){
        return productName;
    }

    public String getProductPrice(ProductPrice mode){
        return mode.getPrice(getProductName());
    }

    public void setProductName(String productName){
        this.productName = productName;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
