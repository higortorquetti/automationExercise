package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContaCriadaPage {

    private WebDriver driver;

    public ContaCriadaPage(WebDriver driver){this.driver = driver;}

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ContaCriadaPage acessoPaginaContaCriadaSucesso() {
        driver.findElement(By.cssSelector("h2[data-qa=\"account-created\"] b")).isDisplayed();
        return this;
    }

                        //-- CLICKS EM BOTÕES --//
    public HomePage clicaNoBotaoContinuar() {
        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();

        return new HomePage(driver);
    }

}
