package Modulos.PageObjects.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBar {
    private WebElement driver;
    private By home = By.cssSelector("a[href=\"/\"]");
    private By products = By.cssSelector("a[href=\"/products\"]");
    private By cart = By.cssSelector("a[href=\"/view_cart\"]");
    private By login = By.cssSelector("a[href=\"/login\"]");
    private By testCases = By.cssSelector("a[href=\"/test_cases\"]");
    private By apiList = By.cssSelector("a[href=\"/api_list\"]");
    private By contactUs = By.cssSelector("a[href=\"/contact_us\"]");

    public NavBar(WebElement driver){
        this.driver = driver;


    }

    
}
