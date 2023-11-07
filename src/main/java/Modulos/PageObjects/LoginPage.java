package Modulos.PageObjects;

import org.openqa.selenium.By;
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
    private By InputPasswordLogin = By.cssSelector("input[type=\"password\"][data-qa=\"login-password\"]");
    private By BtnLogin = By.cssSelector("button[type=\"submit\"][data-qa=\"login-button\"]");
    private By InputNomeSignup = By.cssSelector("input[type=\"text\"][data-qa=\"signup-name\"]");
    private By InputEmailSignup = By.cssSelector("input[type=\"email\"][data-qa=\"signup-email\"]");
    private By BtnSigup = By.cssSelector("button[type=\"submit\"][data-qa=\"signup-button\"]");
    public LoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }


    //-- VERIFICAÇÕES DE PAGINA --//
    public LoginPage verificarAcessoLoginPage(){
            driver.findElement(By.cssSelector("div[class=\"signup-form\"] h2")).isDisplayed();
        return this;
    }



    //-- INSERÇÃO DE DADOS --//
    public LoginPage setInputEmailLogin(String email){
        InputEmailLogin.clear();
        InputEmailLogin.sendKeys(email);

        return this;
    }
    public LoginPage setInputPasswordLogin(String password) {
        WebElement passwordInput = driver.findElement(InputPasswordLogin);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        return this;
    }
    public LoginPage setInputNomeSignup(String nome){
        WebElement nameInput = driver.findElement(InputNomeSignup);
        nameInput.sendKeys(nome);
        return this;
    }
    public LoginPage setInputEmailSignup(String email){
        WebElement emailSingup = driver.findElement(InputEmailSignup);
        emailSingup.sendKeys(email);
        return this;
    }


    //-- CLICKS --//
    public SignupPage clickBtnSignup() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        WebElement signupBtn = driver.findElement(BtnSigup);
        signupBtn.click();

        return new SignupPage(driver);

    }
    public HomePage clickBtnLogin() {
            WebElement loginBtn = driver.findElement(BtnLogin);
            loginBtn.click();
        return new HomePage(driver);
    }
    public LoginPage clickBtnLoginInvalido(){
            WebElement loginBtn = driver.findElement(BtnLogin);
            loginBtn.click();
        return this;
    }
    public LoginPage clickBtnSignupInvalido(){
        WebElement singupBtn = driver.findElement(BtnSigup);
        singupBtn.click();

        return this;
    }


    //-- CAPTURA DE MENSSAGENS --//
    public String getEmailErrorMessageLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement menssagem = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("p[style=\"color: red;\"]")));

        return menssagem.getText();

    }
    public String getEmailErrorMessageSingup() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("id=\"textbox1\"")).getText();
        WebElement menssagem = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("p[style=\"color: red;\"]")));

        return menssagem.getText();
    }
}
