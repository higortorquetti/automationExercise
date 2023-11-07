package Modulos.PageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class ContactUsPage {

    private WebDriver driver;
    public ContactUsPage(WebDriver navegador){this.driver = navegador;}

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ContactUsPage verificaPaginaContactUs(){
        driver.findElement(By
                .cssSelector("div[class=\"col-sm-8\"] div h2[class=\"title text-center\"]")).isDisplayed();

        return this;
    }
    public ContactUsPage verificaMenssagemDeSucessoContatcUs() {
        driver.findElement(By.cssSelector("div[class=\"status alert alert-success\"]")).isDisplayed();

        return this;
    }


                    //-- INSERÇÃO DE DADOS --//
    public ContactUsPage preencherDadosContacUs(
            String name,
            String email,
            String tema,
            String msg,
            String arquivo){

        JavascriptExecutor js = (JavascriptExecutor) driver;

        driver.findElement(By.cssSelector("input[data-qa=\"name\"]")).sendKeys(name);
        driver.findElement(By.cssSelector("input[data-qa=\"email\"]")).sendKeys(email);
        driver.findElement(By.cssSelector("input[data-qa=\"subject\"]")).sendKeys(tema);
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.cssSelector("textarea[data-qa=\"message\"]")).sendKeys(msg);
        driver.findElement(By.cssSelector("input[type=\"file\"]")).sendKeys(arquivo);
        return this;
    }


                    //-- CLICKS EM BOTÕES --//
    public ContactUsPage clicaNoBotaoSubmit(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.cssSelector("input[data-qa=\"submit-button\"]")).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
    public HomePage clicaHomePage(){
        driver.findElement(By.cssSelector("a[class=\"btn btn-success\"]")).click();

        return new HomePage(driver);
    }
}
