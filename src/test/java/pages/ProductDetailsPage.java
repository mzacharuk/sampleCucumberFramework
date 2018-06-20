package pages;

import core.DriverFactory;
import modules.CartLayerPopup;
import org.openqa.selenium.By;
import utils.SeleniumExtender;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class ProductDetailsPage extends BasePage{

    public CartLayerPopup cartLayerPopup = new CartLayerPopup();

    private By productName = By.cssSelector("h1[itemprop='name']");
    private By addToBasketButton = By.id("add_to_cart");
    private By plusButton = By.className("product_quantity_up");

    public ProductDetailsPage clickOnAddToBasket(){
        SeleniumExtender.clickWithWait(addToBasketButton, DriverFactory.getDriver());
        return this;
    }

    public String getProductName(){
        return SeleniumExtender.findElementWithWait(productName, DriverFactory.getDriver()).getText();
    }

    public ProductDetailsPage increaseProductQuantityByPlusButton(){
        SeleniumExtender.clickWithWait(plusButton, DriverFactory.getDriver());
        return this;
    }



}
