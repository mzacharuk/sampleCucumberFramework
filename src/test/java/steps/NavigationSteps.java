package steps;

import core.DriverFactory;
import cucumber.api.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.HomePage;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class NavigationSteps {


    @Given("^I go to dresses category page$")
    public void i_go_to_category_page() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.goToDressesCategory();

    }


    @Given("^I am on home page$")
    public void i_am_on_home_page() throws Throwable {
        WebDriver driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com/");
    }


}
