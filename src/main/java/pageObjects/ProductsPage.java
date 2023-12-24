package pageObjects;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    public static WebDriver driver;

    public ProductsPage(WebDriver driver)
    {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public WebElement sortOption;

    public WebElement menuOption;

    @FindBy(className = "title")
    public WebElement productPageHeading;

    public void verifySuccessfulLogin(String expProductPageHngTxt)
    {
        Assertions.assertEquals(expProductPageHngTxt, productPageHeading.getText());
    }

    public void chooseProduct(String productToChoose)
    {
        driver.findElement(By.xpath("//div[text()='"+productToChoose+"']")).click();
    }


}
