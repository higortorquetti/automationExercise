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

public class SignupPage extends WebBasePage{
    
    private WebDriver driver;
    // Identificação dos elementos com FindBy
    @FindBy (css = "h2[class=\"title text-center\"] b")
    private WebElement signupTextForm;
    @FindBy (css = "input[type=\"radio\"][value=\"Mr\"]")
    private WebElement signupRadioBtnMr;
    @FindBy (css = "input[type=\"password\"][id=\"password\"]")
    private WebElement singupInputPassword;
    @FindBy (css = "select[data-qa=\"days\"]")
    private WebElement singupDayDropdown;
    @FindBy (css = "select[data-qa=\"months\"]")
    private WebElement singupMonthDropdown;
    @FindBy (css = "select[data-qa=\"years\"]")
    private WebElement singupYearDropdown;
    @FindBy (css = "input[type=\"checkbox\"][id=\"newsletter\"]")
    private WebElement signupCheckBoxNewsLetter;
    @FindBy (css = "input[type=\"text\"][id=\"first_name\"]")
    private WebElement singupInputFirstName;
    @FindBy (css = "input[type=\"text\"][id=\"last_name\"]")
    private WebElement singupInputLastName;
    @FindBy (css = "input[type=\"text\"][id=\"address1\"]")
    private WebElement singupInputAdress;
    @FindBy (css = "select[data-qa=\"country\"]")
    private WebElement singupCountryDropDown;
    @FindBy (css = "input[type=\"text\"][id=\"state\"]")
    private WebElement singupInputState;
    @FindBy (css = "input[type=\"text\"][id=\"city\"]")
    private WebElement singupInputCity;
    @FindBy (css = "input[type=\"text\"][id=\"zipcode\"]")
    private WebElement singupInputZipCode;
    @FindBy (css = "input[type=\"text\"][id=\"mobile_number\"]")
    private WebElement signupInputCel;
    @FindBy (css = "button[type=\"submit\"]")
    private WebElement singupBtnCreateAcc;



    public SignupPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }
    public SignupPage verificaAcessoPaginaSignup() {
           signupTextForm.isDisplayed();
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
        signupRadioBtnMr.click();
        singupInputPassword.sendKeys(password);
        js.executeScript("window.scrollBy(0, 500);");

        singupDayDropdown.click();
        singupDayDropdown.findElement(By.cssSelector("option[value=\"" + dia + "\"]")).click();
        singupMonthDropdown.click();
        singupMonthDropdown.findElement(By.cssSelector("option[value=\"" + mes + "\"]")).click();
        singupYearDropdown.click();
        singupYearDropdown.findElement(By.cssSelector("option[value=\"" + ano + "\"]")).click();

        wait.until(ExpectedConditions.elementToBeClickable(signupCheckBoxNewsLetter));
        signupCheckBoxNewsLetter.click();
        singupInputFirstName.sendKeys(firstName);
        singupInputLastName.sendKeys(lastName);
        singupInputAdress.sendKeys(endereco);
        js.executeScript("arguments[0].scrollIntoView(true);", singupCountryDropDown);
        singupCountryDropDown.click();
        singupCountryDropDown.findElement(By.cssSelector("option[value=\"" + pais + "\"]")).click();
        js.executeScript("window.scrollBy(0, 500);");
        singupInputState.sendKeys(estado);
        singupInputCity.sendKeys(cidade);
        singupInputZipCode.sendKeys(cep);
        signupInputCel.sendKeys(celular);
        return this;
    }

                    //-- CLICKS --//
    public ContaCriadaPage clickBtnSignup(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", singupBtnCreateAcc);
        singupBtnCreateAcc.click();
        return new ContaCriadaPage(driver);
    }
}
