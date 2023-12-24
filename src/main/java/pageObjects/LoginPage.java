package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "login_logo")
    public WebElement homePageLogo;

    @FindBy(id="user-name")
    public WebElement usernameInput;

    @FindBy(id="password")
    public WebElement passwordInput;

    @FindBy(id="login-button")
    public WebElement loginButton;

    @FindBy(xpath = "//h3[@data-test='error']")
    public WebElement invalidLoginError;

    public void verifyHomePageLanding()
    {
        Assertions.assertTrue(homePageLogo.isDisplayed());
    }

    public void enterUsername(String username)
    {
        usernameInput.sendKeys(username);
    }

    public void enterPassword(String password)
    {
        passwordInput.sendKeys(password);
    }

    public void clickLoginBtn()
    {
        loginButton.click();
    }

    public void verifyInvalidLogin(String expectedLoginFailedErrorMsg)
    {
        Assertions.assertEquals(invalidLoginError.getText(), expectedLoginFailedErrorMsg);
    }

}
