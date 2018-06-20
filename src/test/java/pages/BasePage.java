package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.pagefactory.ByChained;
import utils.SeleniumExtender;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class BasePage {

    private By shoppingCart = By.className("shopping_cart");
    private By dressesCategoryLink = By.cssSelector("li[title='Dresses']");

    public void clickOnShoppingCart(){
        SeleniumExtender.clickWithWait(shoppingCart, DriverFactory.getDriver());
    }

    public void goToDressesCategory(){
        SeleniumExtender.clickWithWait(dressesCategoryLink, DriverFactory.getDriver());
    }


}
