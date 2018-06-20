package modules;

import core.DriverFactory;
import utils.SeleniumExtender;
import utils.WaitUtil;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class CartLayerPopup extends CartLayerPopupLocators {

    public String getSuccessInfo(){
        WaitUtil.waitUntilVisible(SeleniumExtender.findElementWithWait(popup, DriverFactory.getDriver()), DriverFactory.getDriver());
        return SeleniumExtender.findElementWithWait(successInfo, DriverFactory.getDriver()).getText();
    }

    public void clickOnProceedToCheckout(){
        SeleniumExtender.clickWithWait(proceedToCheckoutButton, DriverFactory.getDriver());
    }
}
