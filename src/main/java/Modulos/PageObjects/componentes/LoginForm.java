package Modulos.PageObjects.componentes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginForm {
    private WebDriver driver;
    private By InputEmailLogin = By.cssSelector("input[type=\"email\"][data-qa=\"login-email\"]");
    private By InputPasswordLogin = By.cssSelector("input[type=\"password\"][data-qa=\"login-email\"]");
    private By BtnLogin = By.cssSelector("button[type=\"submit\"][data-qa=\"login-button\"]");
    private By InputNomeSignup = By.cssSelector("input[type=\"text\"][data-qa=\"signup-name\"]");
    private By InputEmailSignup = By.cssSelector("input[type=\"email\"][data-qa=\"signup-email\"]");
    private By BtnSigup = By.cssSelector("button[type=\"submit\"][data-qa=\"signup-button\"]");

    public LoginForm(WebDriver driver){
        this.driver = driver;
    }

    public void setInputEmailLogin(String email){
        WebElement emailInput = driver.findElement(InputPasswordLogin);
        emailInput.clear();
        emailInput.click();
    }

    public void setInputPasswordLogin(String password) {
        WebElement passwordInput = driver.findElement(InputPasswordLogin);
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }


}
