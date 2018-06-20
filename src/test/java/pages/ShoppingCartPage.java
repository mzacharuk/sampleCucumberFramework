package pages;

import core.DriverFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utils.SeleniumExtender;
import utils.WaitUtil;

import java.util.List;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class ShoppingCartPage extends BasePage {

    @FindBy(how = How.CLASS_NAME, using = "cart_description")
    public List<WebElement> productsDescriptions;


    @FindBy(how = How.CSS, using = "span[id*='total_product_price']")
    public List<WebElement> productsDescriptions2;

    @FindBys({ @FindBy(how = How.CLASS_NAME, using = "cart_total"),
            @FindBy(how = How.CSS,using = "span[id*='total_product_price']")})
    public List<WebElement> totalProductPrices;

    @FindBys({ @FindBy(how = How.CSS,using = "span[id*='product_price']"),
               @FindBy(how = How.CLASS_NAME, using = "price")})
    public List<WebElement> unitProductPrices;


    @FindBy(className = "cart_quantity_input")
    public List<WebElement> productQuantities;

    public void initElements(){
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }

    public ShoppingCartPage(){
        initElements();
    }

    public String getProductDescription(int index){
        WaitUtil.waitForAjax(DriverFactory.getDriver());
        return productsDescriptions.get(index + 1).getText();
    }

    public String getProductUnitPrice(int index){
        WaitUtil.waitForAjax(DriverFactory.getDriver());
        return unitProductPrices.get(index).getText();
    }

    public String getProductTotalPrice(int index){
        WaitUtil.waitForAjax(DriverFactory.getDriver());
        return totalProductPrices.get(index).getText();
    }

    public String getProductQuantity(int index){
        return productQuantities.get(index).getAttribute("value");
    }
}
