package utils;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class SeleniumExtender {


    public static WebElement findElementWithWait(final By by, WebDriver driver){
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.withTimeout(10, TimeUnit.SECONDS);

        return fluentWait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(by);
            }
        });
    }

    public static List<WebElement> findElementsWithWait(final By by, WebDriver driver){
        FluentWait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver);
        fluentWait.ignoring(NoSuchElementException.class);
        fluentWait.withTimeout(10, TimeUnit.SECONDS);

        return fluentWait.until(new Function<WebDriver, List<WebElement>>() {
            public List<WebElement> apply(WebDriver driver) {
                return driver.findElements(by);
            }
        });
    }

    public static void sendKeysWithWait(WebDriver driver, By by, String text){
        WaitUtil.waitForAjax(driver);
        WaitUtil.waitForDOM(driver);
        WebElement element = SeleniumExtender.findElementWithWait(by, driver);
        WaitUtil.waitUntilVisible(element, driver);
        markSelectedElement(element, driver);
        element.sendKeys(text);
    }

    public static void clickWithWait(By by, WebDriver driver){
        WaitUtil.waitForAjax(driver);
        WaitUtil.waitForDOM(driver);
        WebElement element = SeleniumExtender.findElementWithWait(by, driver);
        WaitUtil.waitUntilVisible(element, driver);
        markSelectedElement(element, driver);
        SeleniumExtender.findElementWithWait(by, driver).click();
    }

    public static void clickWithWait(WebElement element, WebDriver driver){
        WaitUtil.waitForAjax(driver);
        WaitUtil.waitForDOM(driver);
        WaitUtil.waitUntilVisible(element, driver);
        markSelectedElement(element, driver);
        element.click();
    }

    private static void markSelectedElement(WebElement element, WebDriver driver){
        JsExecutor.executeScriptWithParameter(driver, "arguments[0].style.border='3px solid red'", element);
    }
}
