package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import pages.ProductDetailsPage;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class ProductDetailsSteps {

    @Autowired
    private Product product;
    private ProductDetailsPage productDetailsPage = new ProductDetailsPage();

    @When("^I click on add product to shopping cart button$")
    public void i_click_on_add_product_to_shopping_cart_button(){
        productDetailsPage.clickOnAddToBasket();
    }

    @Then("^I see popup with following success message$")
    public void i_see_popup_with_following_success_message(List<String> message) throws Throwable {
        String actualMessage = productDetailsPage.cartLayerPopup.getSuccessInfo();
        assertEquals(message.get(0), actualMessage);
    }

    @Given("^I increase product quantity by (\\d+)$")
    public void i_increase_product_quantity_by(int times) throws Throwable {
        product.setQuantity(1 + times);
        for(int i = 0; i < times; i++){
            productDetailsPage.increaseProductQuantityByPlusButton();
        }

    }


    @When("^I click on proceed to checkout button$")
    public void i_click_on_proceed_to_checkout_button() throws Throwable {
        productDetailsPage.cartLayerPopup.clickOnProceedToCheckout();
    }

    @Given("^I add \"([^\"]*)\" to compare$")
    public void i_add_to_compare(String productName) throws Throwable {

    }

    @When("^I click on compare button$")
    public void i_click_on_compare_button() throws Throwable {
    }

    @Then("^I am on compare products page$")
    public void i_am_on_compare_products_page() throws Throwable {
    }

    @Then("^I see correct details of both products$")
    public void i_see_correct_details_of_both_products() throws Throwable {
    }

}
