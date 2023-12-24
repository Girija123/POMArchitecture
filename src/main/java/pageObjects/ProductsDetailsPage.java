package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsDetailsPage {

    public ProductsDetailsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id="back-to-products")
    public WebElement backToProductsBtn;

    @FindBy(xpath="//button[text()='Add to cart']")
    public WebElement addToCartBtn;

    @FindBy(xpath = "//button[text()='Remove']")
    public WebElement removeBtn;

    public void verifyProductDetailsPageLanding()
    {
        Assertions.assertTrue(backToProductsBtn.isDisplayed());
    }

    public void clickAddToCartButton()
    {
        addToCartBtn.click();
    }

    public void verifyRemove()
    {
        Assertions.assertTrue(removeBtn.isDisplayed());
    }
}
