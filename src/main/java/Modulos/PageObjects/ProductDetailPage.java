package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductDetailPage {

    private WebDriver driver;

    public ProductDetailPage(WebDriver driver){this.driver = driver;}

    public ProductDetailPage verificaProdutoDetail(){
        driver.findElement(By.cssSelector("div[class=\"product-details\"]")).isDisplayed();

        return this;
    }

}
