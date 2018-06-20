package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class JsExecutor {

    public static void executeScript(WebDriver driver, String script){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(script);
    }

    public static String executeScriptAndReturn(WebDriver driver, String script){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(script).toString();
    }
    public static void executeScriptWithParameter(WebDriver driver, String script, Object param){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript(script, param);
    }

    public static String executeScriptWithParameterAndReturn(WebDriver driver, String script, Object param){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        return jsExecutor.executeScript(script, param).toString();
    }

    public static void executeAsyncScript(WebDriver driver, String script){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeAsyncScript(script);
    }
    public static void executeAsyncScriptWithParameter(WebDriver driver, String script, Object param){
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeAsyncScript(script, param);
    }



}

