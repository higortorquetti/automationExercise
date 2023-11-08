package Modulos.PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends WebBasePage {

    protected WebDriver driver;
    @FindBy (css = "a[href=\"/\"]")
    private WebElement navBarHomeLink;
    @FindBy (css = "a[href=\"/products\"]")
    private WebElement navBarProductsLink;
    @FindBy (css = "a[href=\"/view_cart\"]")
    private WebElement navBarCartLink;
    @FindBy (css = "a[href=\"/login\"]")
    private WebElement navBarLoginLink;
    @FindBy (css = "a[href=\"/contact_us\"]")
    private WebElement navBarContactUsLink;
    @FindBy (css = "a[href=\"/logout\"]")
    private WebElement navBarLogoutLink;
    @FindBy (css = "li a[href=\"/delete_account\"]")
    private WebElement navBarDeleteAccLink;
    @FindBy (css = "input[id=\"susbscribe_email\"]")
    private WebElement homeInputSubcribe;
    @FindBy (css = "button[id=\"subscribe\"]")
    private WebElement homeBtnSubscribe;
    @FindBy (css = "div[id=\"success-subscribe\"] div")
    private WebElement homeSubscribeSucessMessage;
    @FindBy (css = "div[class=\"carousel-inner\"]")
    private WebElement homeCarrocel;
    public HomePage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public HomePage verificaAcessoPaginaHome(){
        homeCarrocel.isDisplayed();
        return this;
    }
    public HomePage verificarSeEstaLogado(){
            navBarLogoutLink.isDisplayed();
        return this;
    }


                    //-- INSERÇÃO DE DADOS --//
    public HomePage subscriptionEmail(String email){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        homeInputSubcribe.sendKeys(email);
        return this;
    }
    

                            //-- CLICKS --//
    public LoginPage clickLinkLogout(){
        navBarLogoutLink.click();
        return new LoginPage(driver);
    }
    public HomePage clickBtnSubscribe(){
        homeBtnSubscribe.click();
        return this;
    }
    public ContaExcluidaPage clickLinkDeleteAcc(){
        navBarDeleteAccLink.click();
        return new ContaExcluidaPage(driver);
    }


                    //-- CAPTURA DE MENSSAGENS --//
    public String getSubscribeSucecssMessage(){
        return homeSubscribeSucessMessage.getText();
    }



}
