package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class WaitUtil {


    public static void waitUntilVisible(WebElement element, WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitForAjax(final WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10, 10);
        ExpectedCondition<Boolean> conditions = new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver) {
                return JsExecutor.executeScriptAndReturn(driver, "return jQuery.active == 0").equals("true");
            }
        };
        wait.until(conditions);
    }

    public static void waitForDOM(final WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 10, 10);
        ExpectedCondition<Boolean> conditions = new ExpectedCondition<Boolean>(){
            public Boolean apply(WebDriver driver) {
                return JsExecutor.executeScriptAndReturn(driver, "return document.readyState").equals("complete");
            }
        };
        wait.until(conditions);
    }
}
