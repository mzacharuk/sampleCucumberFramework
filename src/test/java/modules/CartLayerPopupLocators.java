package modules;

import org.openqa.selenium.By;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class CartLayerPopupLocators {

    public By popup = By.id("layer_cart");
    public By successInfo = By.tagName("h2");
    public By proceedToCheckoutButton = By.cssSelector("a[title*='Proceed to checkout']");
}
