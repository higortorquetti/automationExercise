package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    
    private WebDriver driver;
    public SignupPage(WebDriver driver){this.driver = driver;}

    public SignupPage verificaAcessoPaginaSignup() {
        driver.findElement(By.cssSelector("div h2 b")).isDisplayed();

        return this;
    }

    public SignupPage preencherDadosSignup(
            String password,
            int dia,
            int mes,
            int ano,
            String firstName,
            String lastName,
            String rua,
            String estado,
            String cidade,
            String cep,
            String celular){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.findElement(By.cssSelector("input[type=\"radio\"][value=\"Mr\"]")).click();
        driver.findElement(By.cssSelector("input[type=\"password\"][id=\"password\"]"))
                .sendKeys(password);
        js.executeScript("window.scrollBy(0, 500);");

        WebElement dayDropdown = driver.findElement(By.cssSelector("select[data-qa=\"days\"]"));
        WebElement monthDropdown = driver.findElement(By.cssSelector("select[data-qa=\"months\"]"));
        WebElement yearDropdown = driver.findElement(By.cssSelector("select[data-qa=\"years\"]"));

        dayDropdown.click();
        dayDropdown.findElement(By.cssSelector("option[value=\"" + dia + "\"]")).click();
        monthDropdown.click();
        monthDropdown.findElement(By.cssSelector("option[value=\"" + mes + "\"]")).click();
        yearDropdown.click();
        yearDropdown.findElement(By.cssSelector("option[value=\"" + ano + "\"]")).click();

        WebElement checkBox = wait.until(ExpectedConditions
                .elementToBeClickable(By.cssSelector("input[type=\"checkbox\"][id=\"newsletter\"]")));
        checkBox.click();
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.cssSelector("input[type=\"text\"][id=\"first_name\"]"))
                .sendKeys(firstName);
        driver.findElement(By.cssSelector("input[type=\"text\"][id=\"last_name\"]"))
                .sendKeys(lastName);
        driver.findElement(By.cssSelector("input[type=\"text\"][id=\"address1\"]"))
                .sendKeys(rua);
        driver.findElement(By.cssSelector("select[data-qa=\"country\"] option[value=\"Canada\"]"))
                .click();
        driver.findElement(By.cssSelector("input[type=\"text\"][id=\"state\"]"))
                .sendKeys(estado);
        driver.findElement(By.cssSelector("input[type=\"text\"][id=\"city\"]"))
                .sendKeys(cidade);
        driver.findElement(By.cssSelector("input[type=\"text\"][id=\"zipcode\"]"))
                .sendKeys(cep);
        driver.findElement(By.cssSelector("input[type=\"text\"][id=\"mobile_number\"]"))
                .sendKeys(celular);

        return this;
    }

    public ContaCriadaPage clicaNoBotaoSignup(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.cssSelector("button[type=\"submit\"][data-qa=\"create-account\"]"))
                .click();
        return new ContaCriadaPage(driver);
    }
}
