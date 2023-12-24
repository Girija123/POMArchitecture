package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasketPage {

    public static WebDriver driver;

    public BasketPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className="shopping_cart_badge")
    public WebElement basketBadge;

    @FindBy(className = "shopping_cart_link")
    public WebElement basketIcon;

    @FindBy(className = "title")
    public WebElement basketPageHeading;

    @FindBy(xpath="//button[text()='Remove']")
    public WebElement removeBtn;

    public void verifyBasketBadgeUpdate(String productCount)
    {
        Assertions.assertTrue(basketBadge.getText().equals(productCount));
    }

    public void clickBasketIcon()
    {
        basketIcon.click();
    }

    public void verifyBasketPageLanding()
    {
        Assertions.assertTrue(basketPageHeading.isDisplayed());
    }

    public void verifyProductInBag(String expProductInBag)
    {
        Assertions.assertTrue(driver.findElement(By.xpath("//div[text()='"+expProductInBag+"']")).isDisplayed());
    }

    public void clickRemoveBtn()
    {
        removeBtn.click();
    }

}
