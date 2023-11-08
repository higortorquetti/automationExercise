package Modulos.PageObjects;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends WebBasePage{
    private WebDriver driver;
    @FindBy (css = "input[type=\"email\"][data-qa=\"login-email\"]")
    private WebElement InputEmailLogin;
    @FindBy (css = "input[type=\"password\"][data-qa=\"login-password\"]")
    private WebElement InputPasswordLogin;
    @FindBy (css = "button[type=\"submit\"][data-qa=\"login-button\"]")
    private WebElement BtnLogin;
    @FindBy (css = "input[type=\"text\"][data-qa=\"signup-name\"]")
    private WebElement InputNomeSignup;
    @FindBy (css = "input[type=\"email\"][data-qa=\"signup-email\"]")
    private WebElement InputEmailSignup;
    @FindBy (css = "button[type=\"submit\"][data-qa=\"signup-button\"]")
    private WebElement BtnSigup;
    @FindBy (css = "div[class=\"signup-form\"] h2")
    private WebElement textLoginPage;
    @FindBy (css = "p[style=\"color: red;\"]")
    private WebElement errorMessageLogin;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    //-- VERIFICAÇÕES DE PAGINA --//
    public LoginPage verificarAcessoLoginPage(){
            textLoginPage.isDisplayed();
        return this;
    }



    //-- INSERÇÃO DE DADOS --//
    public LoginPage setInputEmailLogin(String email){
        InputEmailLogin.clear();
        InputEmailLogin.sendKeys(email);

        return this;
    }
    public LoginPage setInputPasswordLogin(String password) {
        InputPasswordLogin.clear();
        InputPasswordLogin.sendKeys(password);

        return this;
    }
    public LoginPage setInputNomeSignup(String nome){
        InputNomeSignup.sendKeys(nome);
        return this;
    }
    public LoginPage setInputEmailSignup(String email){
        InputEmailSignup.sendKeys(email);
        return this;
    }


    //-- CLICKS --//
    public SignupPage clickBtnSignup() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        BtnSigup.click();
        return new SignupPage(driver);

    }
    public HomePage clickBtnLogin() {
        BtnLogin.click();
        return new HomePage(driver);
    }
    public LoginPage clickBtnLoginInvalido(){
        BtnLogin.click();
        return this;
    }
    public LoginPage clickBtnSignupInvalido(){
        BtnSigup.click();
        return this;
    }


    //-- CAPTURA DE MENSSAGENS --//
    public String getEmailErrorMessageLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return errorMessageLogin.getText();

    }
    public String getEmailErrorMessageSingup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(errorMessageLogin));
        return errorMessageLogin.getText();
    }
}
