package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;

    public LoginPage(WebDriver driver){this.driver = driver;}

                //-- VERIFICAÇÕES DE PAGINA --//
    public LoginPage verificarAcessoLoginPage(){
        driver.findElement(By.cssSelector("div[class=\"signup-form\"] h2")).isDisplayed();

        return this;
    }



                   //-- INSERÇÃO DE DADOS --//
    public LoginPage inserirEmailLogin(String email){
            driver.findElement(By.cssSelector("form[action=\"/login\"] input[type=\"email\"]")).sendKeys(email);
        return this;
    }
    public LoginPage inserirSenhaLogin(String password){
            driver.findElement(By.cssSelector("form[action=\"/login\"] input[type=\"password\"]")).sendKeys(password);
        return this;
    }
    public LoginPage inserirNomeSignup(String nome){
        driver.findElement(By.cssSelector("input[data-qa=\"signup-name\"]")).sendKeys(nome);
        return this;
    }
    public LoginPage inserirEmailSignup(String email){
        driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys(email);
        return this;
    }



                   //-- CLICKS EM BOTÕES --//
    public SignupPage clicaBtnSigupPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.cssSelector("form[action=\"/signup\"] button[type=\"submit\"]")).click();

        return new SignupPage(driver);

    }
    public LoginPage clicarNoBotaoSignupEmailExistente(){
        driver.findElement(By.cssSelector("button[data-qa=\"signup-button\"]")).click();

        return this;
    }
    public HomePage clicaNoBotaoDeLogin(){
        driver.findElement(By.cssSelector("form[action=\"/login\"] button[type=\"submit\"]")).click();

        return new HomePage(driver);
    }
    public LoginPage clicaNoBotaoDeLoginEmailErrado(){
        driver.findElement(By.cssSelector("form[action=\"/login\"] button[type=\"submit\"]")).click();

        return this;
    }



                 //-- CAPTURA DE MENSSAGENS --//
    public String capturaMenssagemEmailIncorreto() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement menssagem = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("p[style=\"color: red;\"]")));

        return menssagem.getText();

    }
    public String capturaMenssagemEmailExistente() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("form[action=\"/login\"] button[type=\"submit\"]")).click();
        WebElement menssagem = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("p[style=\"color: red;\"]")));

        return menssagem.getText();
    }
}
