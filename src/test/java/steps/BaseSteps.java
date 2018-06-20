package steps;

import core.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class BaseSteps {

    @Before
    public void beforeScenario(){
        DriverFactory.initializeDriver();
    }

    @After
    public void afterScenario(){
        DriverFactory.quitDriver();
    }

}
