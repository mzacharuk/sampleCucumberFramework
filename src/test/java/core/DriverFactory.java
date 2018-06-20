package core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;


/**
 * Created by mzacharuk on 2017-06-20
 */
public class DriverFactory {

    public static ThreadLocal<DriverThread> driverThread;

    @BeforeClass
    public static void initializeDriver(){

        driverThread = new ThreadLocal<DriverThread>(){
            @Override
            protected DriverThread initialValue(){
                DriverThread driverThread = new DriverThread();
                driverThread.initializeDriver();
                return driverThread;
            }
        };

    }

    public static WebDriver getDriver(){
        return driverThread.get().getDriver();
    }

    @After
    public void clearCookies(){
        if(driverThread.get().getDriver() != null){
            driverThread.get().getDriver().manage().deleteAllCookies();
        }
    }

    @AfterClass
    public static void quitDriver(){
        driverThread.get().quitDriver();
    }



}
