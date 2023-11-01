package Modulos.PageObjects;

import org.openqa.selenium.By;
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

    public ContaExcluidaPage excluirContaNovoUsuario(){
        driver.findElement(By.cssSelector("li a[href=\"/delete_account\"]")).click();
        return new ContaExcluidaPage(driver);
    }

    public LoginPage acessaPaginaDeLogin() {
        driver.findElement(By.cssSelector("div ul li a[href=\"/login\"]")).click();

        return new LoginPage(driver);
    }

}
