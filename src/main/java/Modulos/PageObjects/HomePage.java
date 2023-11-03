package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomePage {

    protected WebDriver driver;
    public HomePage(WebDriver driver){this.driver = driver;}
    public HomePage verificarPaginaHome(){
        driver.findElement(By.cssSelector("div ul li a[href=\"/\"][ style=\"color: orange;\"]")).isDisplayed();
        return this;
    }
    public HomePage verificarSeEstaLogado(){
        driver.findElement(By.cssSelector("ul li a[href=\"/logout\"]")).isDisplayed();

        return this;
    }
    public LoginPage clicaNoBotaoLogout(){
        driver.findElement(By.cssSelector("ul li a[href=\"/logout\"]")).click();

        return new LoginPage(driver);
    }
    public HomePage clicaBtnSubscribe(){
        driver.findElement(By.cssSelector("button[id=\"subscribe\"]")).click();
        return this;
    }
    public ContaExcluidaPage excluirContaNovoUsuario(){
        driver.findElement(By.cssSelector("li a[href=\"/delete_account\"]")).click();
        return new ContaExcluidaPage(driver);
    }
    public LoginPage acessaPaginaDeLogin() {
        driver.findElement(By.cssSelector("div ul li a[href=\"/login\"]")).click();

        return new LoginPage(driver);
    }

    public String capturaMenssagemSucesso(){
        return driver.findElement(By.cssSelector("div[id=\"success-subscribe\"] div")).getText();
    }

    public HomePage subscriptionEmail(String email){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500)");
        driver.findElement(By.cssSelector("input[id=\"susbscribe_email\"]")).sendKeys(email);
        return this;
    }

}
