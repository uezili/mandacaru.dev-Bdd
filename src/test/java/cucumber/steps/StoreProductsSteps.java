package cucumber.steps;

import com.livecodebdd.controller.ProductController;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.spring.CucumberContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@CucumberContextConfiguration
public class StoreProductsSteps {
    @Given("i have more than {int} products in my store")
    public void iHaveMoreThanProductsInMyStore(int productsNumber) {
        ProductController products = new ProductController();

        assertTrue("i have more than {int} products in my store",
                products.getAllProducts().size()>productsNumber);

    }

    @And("One of these products is a cellPhone")
    public void oneOfTheseProductsIsACellPhone() {
        ProductController products = new ProductController();
        assertTrue("One of these products is a cellPhone",
                products.getAllProducts().contains("CellPhone"));
    }

    @Then("All product should be returned successfully")
    public void allProductShouldBeReturnedSuccessfully() {
        // Tripe AAA
        //Arrange
        List<String> productToBeVerified = new ArrayList<>();

        productToBeVerified.add("Mouse");
        productToBeVerified.add("keyboard");
        productToBeVerified.add("Pen");
        productToBeVerified.add("Screen");
        productToBeVerified.add("Notebook");
        productToBeVerified.add("CellPhone");

        //Act
        ProductController products = new ProductController();

        //Assert
        assertTrue("All product should be returned successfully",
                products.getAllProducts().containsAll(productToBeVerified));
    }
}
