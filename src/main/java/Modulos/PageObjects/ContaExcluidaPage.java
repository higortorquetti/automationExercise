package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ContaExcluidaPage {
    
    private WebDriver driver;
    public ContaExcluidaPage(WebDriver driver){this.driver = driver;}

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ContaExcluidaPage verificaPaginaContaExcluida(){
        driver.findElement(By.cssSelector("h2[data-qa=\"account-deleted\"] b")).isDisplayed();
        return this;
    }

                        //-- CLICKS EM BOTÕES --//
    public HomePage clicaNoBotaoContinuar() {
        driver.findElement(By.cssSelector("a[data-qa=\"continue-button\"]")).click();

        return new HomePage(driver);
    }
}
