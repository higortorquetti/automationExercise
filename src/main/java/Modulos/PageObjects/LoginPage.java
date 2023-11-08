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
    private WebElement loginInputEmail;
    @FindBy (css = "input[type=\"password\"][data-qa=\"login-password\"]")
    private WebElement loginInputPassword;
    @FindBy (css = "button[type=\"submit\"][data-qa=\"login-button\"]")
    private WebElement longinBtn;
    @FindBy (css = "input[type=\"text\"][data-qa=\"signup-name\"]")
    private WebElement signupInputName;
    @FindBy (css = "input[type=\"email\"][data-qa=\"signup-email\"]")
    private WebElement signupInputEmail;
    @FindBy (css = "button[type=\"submit\"][data-qa=\"signup-button\"]")
    private WebElement signupBtn;
    @FindBy (css = "div[class=\"signup-form\"] h2")
    private WebElement loginText;
    @FindBy (css = "p[style=\"color: red;\"]")
    private WebElement loginErrorMessage;
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    //-- VERIFICAÇÕES DE PAGINA --//
    public LoginPage verificarAcessoLoginPage(){
            loginText.isDisplayed();
        return this;
    }



    //-- INSERÇÃO DE DADOS --//
    public LoginPage setLoginInputEmail(String email){
        loginInputEmail.clear();
        loginInputEmail.sendKeys(email);

        return this;
    }
    public LoginPage setLoginInputPassword(String password) {
        loginInputPassword.clear();
        loginInputPassword.sendKeys(password);

        return this;
    }
    public LoginPage setSignupInputName(String nome){
        signupInputName.sendKeys(nome);
        return this;
    }
    public LoginPage setSignupInputEmail(String email){
        signupInputEmail.sendKeys(email);
        return this;
    }


    //-- CLICKS --//
    public SignupPage clickBtnSignup() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        signupBtn.click();
        return new SignupPage(driver);

    }
    public HomePage clickBtnLogin() {
        longinBtn.click();
        return new HomePage(driver);
    }
    public LoginPage clickBtnLoginInvalido(){
        longinBtn.click();
        return this;
    }
    public LoginPage clickBtnSignupInvalido(){
        signupBtn.click();
        return this;
    }


    //-- CAPTURA DE MENSSAGENS --//
    public String getEmailErrorMessageLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        return loginErrorMessage.getText();

    }
    public String getEmailErrorMessageSingup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        wait.until(ExpectedConditions.visibilityOf(loginErrorMessage));
        return loginErrorMessage.getText();
    }
}
