package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebBasePage {

    protected WebDriver driver;
    @FindBy (css = "a[href=\"/\"]")
    private WebElement homeLink;
    @FindBy (css = "a[href=\"/products\"]")
    private WebElement productsLink;
    @FindBy (css = "a[href=\"/view_cart\"]")
    private WebElement cartLink;
    @FindBy (css = "a[href=\"/login\"]")
    private WebElement loginLink;
    @FindBy (css = "a[href=\"/test_cases\"]")
    private WebElement testCasesLink;
    @FindBy (css = "a[href=\"/api_list\"]")
    private WebElement apiListLink;
    @FindBy (css = "a[href=\"/contact_us\"]")
    private WebElement contactUsLink;
    @FindBy (css = "a[href=\"/logout\"]")
    private WebElement logoutLink;
    @FindBy (css = "li a[href=\"/delete_account\"]")
    private WebElement deleteAccLink;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public HomePage verificarPaginaHome(){
        driver.findElement(By.cssSelector("div ul li a[href=\"/\"][ style=\"color: orange;\"]")).isDisplayed();
        return this;
    }
    public HomePage verificarSeEstaLogado(){
            logoutLink.isDisplayed();
        return this;
    }


                    //-- INSERÇÃO DE DADOS --//
    public HomePage subscriptionEmail(String email){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        driver.findElement(By.cssSelector("input[id=\"susbscribe_email\"]")).sendKeys(email);
        return this;
    }
    

                            //-- CLICKS --//
    public LoginPage clickLogoutBtn(){
            logoutLink.click();
        return new LoginPage(driver);
    }
    public HomePage clicaBtnSubscribe(){
        driver.findElement(By.cssSelector("button[id=\"subscribe\"]")).click();
        return this;
    }
    public ContaExcluidaPage clickLinkDeleteAcc(){
        deleteAccLink.click();
        return new ContaExcluidaPage(driver);
    }


                    //-- CAPTURA DE MENSSAGENS --//
    public String capturaMenssagemSucesso(){
        return driver.findElement(By.cssSelector("div[id=\"success-subscribe\"] div")).getText();
    }



}
