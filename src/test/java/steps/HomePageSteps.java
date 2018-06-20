package steps;

import core.DriverFactory;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.eo.Se;
import pages.HomePage;
import pages.UserActions;
import utils.SeleniumExtender;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class HomePageSteps {

    @Given("^I go to product details page by product name link$")
    public void i_go_to_product_details_page_by_product_name_link() throws Throwable {
        HomePage homePage = new HomePage();
        homePage.clickOnProductName(0);
    }

    @Given("^I search for phrase (.+)$")
    public void i_search_for_phrase(String phrase){
        HomePage homePage = new HomePage();
        homePage.searchForPhrase(phrase);
    }

    @When("^I press search button$")
    public void i_press_given_button() {
        HomePage homePage = new HomePage();
        homePage.clickOnSearchButton();

    }

    @When("^I move mouse on chosen product$")
    public void i_move_mouse_on_chosen_product() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should see the messege (.+)$")
    public void i_should_see_the_messege_No_results_were_found_for_your_search(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

}
