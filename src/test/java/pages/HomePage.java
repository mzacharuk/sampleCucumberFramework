package pages;

import core.DriverFactory;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.SeleniumExtender;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class HomePage extends BasePage{

    private By searchInput = By.id("search_query_top");
    private By searchButton = By.name("submit_search");

    public List<WebElement> getProductsContainers(){
        return SeleniumExtender.findElementsWithWait(By.className("ajax_block_product"), DriverFactory.getDriver());
    }

    public WebElement getProductNameForProductTile(WebElement element){
        return element.findElement(By.className("product-name"));
    }

    public WebElement getQuickViewLinkForProductTile(WebElement element){
        return element.findElement(By.className("quick-view"));
    }

    public void clickOnProductName(int index){
        SeleniumExtender.clickWithWait(getProductNameForProductTile(getProductsContainers().get(index)), DriverFactory.getDriver());
    }

    public void searchForPhrase(String phrase){
        SeleniumExtender.sendKeysWithWait(DriverFactory.getDriver(),searchInput,phrase);
    }

    public void clickOnSearchButton(){
        SeleniumExtender.clickWithWait(searchButton,DriverFactory.getDriver());
    }
}
