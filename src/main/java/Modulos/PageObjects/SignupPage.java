package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignupPage {
    
    private WebDriver driver;
    // Identificação dos elementos com FindBy
    @FindBy (css = "h2[class=\"title text-center\"] b")
    private WebElement textSignupForm;
    @FindBy (css = "input[type=\"radio\"][value=\"Mr\"]")
    private WebElement radioBtnMr;
    @FindBy (css = "input[type=\"password\"][id=\"password\"]")
    private WebElement inputPassword;
    @FindBy (css = "select[data-qa=\"days\"]")
    private WebElement dayDropdown;
    @FindBy (css = "select[data-qa=\"months\"]")
    private WebElement monthDropdown;
    @FindBy (css = "select[data-qa=\"years\"]")
    private WebElement yearDropdown;
    @FindBy (css = "input[type=\"checkbox\"][id=\"newsletter\"]")
    private WebElement checkBoxNewsLetter;
    @FindBy (css = "input[type=\"text\"][id=\"first_name\"]")
    private WebElement inputFirstName;
    @FindBy (css = "input[type=\"text\"][id=\"last_name\"]")
    private WebElement inputLastName;
    @FindBy (css = "input[type=\"text\"][id=\"address1\"]")
    private WebElement inputAdress;
    @FindBy (css = "select[data-qa=\"country\"]")
    private WebElement countryDropDown;
    @FindBy (css = "input[type=\"text\"][id=\"state\"]")
    private WebElement inputState;
    @FindBy (css = "input[type=\"text\"][id=\"city\"]")
    private WebElement inputCity;
    @FindBy (css = "input[type=\"text\"][id=\"zipcode\"]")
    private WebElement inputZipCode;
    @FindBy (css = "input[type=\"text\"][id=\"mobile_number\"]")
    private WebElement inputCel;
    @FindBy (css = "button[type=\"submit\"]")
    private WebElement BtnCreateAcc;



    public SignupPage(WebDriver driver){this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public SignupPage verificaAcessoPaginaSignup() {
           textSignupForm.isDisplayed();
        return this;
    }

                    //-- INSERÇÃO DE DADOS --//
    public SignupPage setDataSignupForm(
            String password,
            int dia,
            int mes,
            int ano,
            String firstName,
            String lastName,
            String endereco,
            String pais,
            String estado,
            String cidade,
            String cep,
            String celular){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        radioBtnMr.click();
        inputPassword.sendKeys(password);
        js.executeScript("window.scrollBy(0, 500);");

        dayDropdown.click();
        dayDropdown.findElement(By.cssSelector("option[value=\"" + dia + "\"]")).click();
        monthDropdown.click();
        monthDropdown.findElement(By.cssSelector("option[value=\"" + mes + "\"]")).click();
        yearDropdown.click();
        yearDropdown.findElement(By.cssSelector("option[value=\"" + ano + "\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(checkBoxNewsLetter));
        checkBoxNewsLetter.click();
        inputFirstName.sendKeys(firstName);
        inputLastName.sendKeys(lastName);
        inputAdress.sendKeys(endereco);
        js.executeScript("arguments[0].scrollIntoView(true);", countryDropDown);
        countryDropDown.click();
        countryDropDown.findElement(By.cssSelector("option[value=\"" + pais + "\"]")).click();
        js.executeScript("window.scrollBy(0, 500);");
        inputState.sendKeys(estado);
        inputCity.sendKeys(cidade);
        inputZipCode.sendKeys(cep);
        inputCel.sendKeys(celular);
        return this;
    }

                    //-- CLICKS EM BOTÕES --//
    public ContaCriadaPage clickBtnSignup(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", BtnCreateAcc);
        BtnCreateAcc.click();
        return new ContaCriadaPage(driver);
    }
}
