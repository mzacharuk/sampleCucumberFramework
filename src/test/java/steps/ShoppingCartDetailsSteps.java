package steps;

import core.DriverFactory;
import cucumber.api.java.en.Then;
import domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import pages.ShoppingCartPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mzacharuk on 2017-06-20
 */
public class ShoppingCartDetailsSteps {

    @Autowired
    private Product product;

    @Then("^I am on shopping cart page$")
    public void i_am_on_shopping_cart_page() throws Throwable {
        assertTrue(DriverFactory.getDriver().getCurrentUrl().contains("order"));
    }

    @Then("^I see added product in shopping cart summary$")
    public void i_see_added_product_in_shopping_cart_summary() throws Throwable {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        String productDescription = shoppingCartPage.getProductDescription(0);
        assertTrue(productDescription.contains("Faded Short Sleeve T-shirts"));
    }

    @Then("^I see correct number of product in shopping cart summary$")
    public void i_see_correct_number_of_added_product_in_shopping_cart_summary() throws Throwable {
        ShoppingCartPage shoppingCartPage = new ShoppingCartPage();
        String actualQuantity = shoppingCartPage.getProductQuantity(0);
        assertEquals(Integer.toString(product.getQuantity()), actualQuantity);
    }

}
