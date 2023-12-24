package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasketPage;
import pageObjects.ProductsDetailsPage;
import pageObjects.ProductsPage;

public class BasketSteps extends CommonFunctions {

    ProductsPage productsPage = new ProductsPage(driver);
    ProductsDetailsPage productsDetailsPage = new ProductsDetailsPage(driver);
    BasketPage basketPage = new BasketPage(driver);


    @When("I choose a product {string}")
    public void chooseProduct(String productName)
    {
        productsPage.chooseProduct(productName);
        productsDetailsPage.verifyProductDetailsPageLanding();
    }

    @When("I click add to cart button with count {string}")
    public void addToCart(String productCount)
    {
        productsDetailsPage.clickAddToCartButton();
        productsDetailsPage.verifyRemove();
        basketPage.verifyBasketBadgeUpdate(productCount);
    }

    @When("I click basket icon")
    public void clickCart()
    {
        basketPage.clickBasketIcon();
        basketPage.verifyBasketPageLanding();
    }

    @Then("the product {string} in the bag")
    public void verifyProductInCart(String expProductInBag)
    {
        basketPage.verifyProductInBag(expProductInBag);
    }

    @When("I click remove button")
    public void removeProductFromCart()
    {
        basketPage.clickRemoveBtn();
    }

    @Then("the product {string} shouldn't be in the bag")
    public void verifyRemoveProduct(String notExpProductInBag)
    {

    }
}
