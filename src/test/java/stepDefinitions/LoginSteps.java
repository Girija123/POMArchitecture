package stepDefinitions;

import functionLibrary.CommonFunctions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.BasketPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;

public class LoginSteps extends CommonFunctions {

    LoginPage loginPage = new LoginPage(driver);
    ProductsPage productsPage = new ProductsPage(driver);

    @Given("I am on home page {string}")
    public void openHomePage(String url)
    {
        driver.get(url);
        loginPage.verifyHomePageLanding();
    }

    @When("I enter Username {string} and password {string}")
    public void enterCredentials(String username, String password)
    {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("I click login button")
    public void clickLoginButton()
    {
        loginPage.clickLoginBtn();
    }

    @Then("I should login successfully and gets directed to products page with heading {string}")
    public void verifyValidLogin(String expectedProductPageHeading)
    {
        productsPage.verifySuccessfulLogin(expectedProductPageHeading);
    }

    @Then("I shouldn't be allowed login and gets error message {string}")
    public void verifyInvalidLogin(String invalidLoginErrorMessage)
    {
        loginPage.verifyInvalidLogin(invalidLoginErrorMessage);
    }
}
