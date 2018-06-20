package core;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class DriverThread {

    private WebDriver driver;
    private BrowserType type;
    private boolean remote = Boolean.getBoolean("remoteDriver");
    private String gridUrl = System.getProperty("gridUrl");

    public void initializeDriver(){
        if(driver == null){
           if(remote){
               try {
                   startDriverRemotely();
               } catch (MalformedURLException e) {
                   e.printStackTrace();
               }
           }else {
               startDriverLocally();
           }
        }
    }

    private void startDriverLocally(){
        determineBrowserType();
        switch (type){
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
                FirefoxDriverManager.getInstance().setup();
                driver = new FirefoxDriver();
                break;
            default:
                System.out.println("Other browsers are not supported, will launch chrome anyway");
                ChromeDriverManager.getInstance().setup();
                driver = new ChromeDriver();
                break;
        }
    }

    private void startDriverRemotely() throws MalformedURLException {
        determineBrowserType();
        switch (type){
            case CHROME:
                driver = new RemoteWebDriver(new URL(gridUrl), DesiredCapabilities.chrome());
                break;
            case FIREFOX:
                driver = new RemoteWebDriver(new URL(gridUrl), DesiredCapabilities.firefox());
                break;
            default:
                System.out.println("Other browsers are not supported, will launch chrome anyway");
                driver = new RemoteWebDriver(new URL(gridUrl), DesiredCapabilities.chrome());
                break;
        }
    }

    private void determineBrowserType(){
        type = BrowserType.valueOf(System.getProperty("browser-type").toUpperCase());
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void quitDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
