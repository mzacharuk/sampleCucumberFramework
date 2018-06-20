package pages;

import core.DriverFactory;
import org.openqa.selenium.By;
import utils.SeleniumExtender;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class UserActions {

    public static void addProductFromHomePageToShoppingCart(int index, int productQuantity){
        HomePage homePage = new HomePage();
        homePage.clickOnProductName(index);
        ProductDetailsPage productDetailsPage = new ProductDetailsPage();
        for(int i = 1; i <productQuantity; i++){
            productDetailsPage.increaseProductQuantityByPlusButton();
        }
        productDetailsPage.clickOnAddToBasket();
    }

    public static void addProductToShoppingCartAndProceedToCheckout(int index, int productQuantity){
        addProductFromHomePageToShoppingCart(index,productQuantity);
        new ProductDetailsPage().cartLayerPopup.clickOnProceedToCheckout();
    }

}
