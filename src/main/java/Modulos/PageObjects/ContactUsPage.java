package Modulos.PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends WebBasePage {

    private WebDriver driver;
    @FindBy (css = "div[class=\"status alert alert-success\"]")
    private WebElement contactusSucessMessage;
    @FindBy (css = "input[data-qa=\"submit-button\"]")
    private WebElement contactusBtnSubmit;
    @FindBy (css = "input[data-qa=\"name\"]")
    private WebElement contactusInputName;
    @FindBy (css = "input[data-qa=\"email\"]")
    private WebElement contactusInputEmail;
    @FindBy (css = "input[data-qa=\"subject\"]")
    private WebElement contactusInputTema;
    @FindBy (css = "textarea[data-qa=\"message\"]")
    private WebElement contactusTextArea;
    @FindBy (css = "input[type=\"file\"]")
    private WebElement contactusInputArquivo;
    @FindBy (css = "div[class=\"col-sm-8\"] div h2[class=\"title text-center\"]")
    private WebElement contatacUsTextTitle;
    public ContactUsPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ContactUsPage verificaPaginaContactUs(){
        contatacUsTextTitle.isDisplayed();
        return this;
    }
    public ContactUsPage verificaMenssagemDeSucessoContatcUs() {
        contactusSucessMessage.isDisplayed();
        return this;
    }


                    //-- INSERÇÃO DE DADOS --//
    public ContactUsPage setDataContatcUsForm(
            String name,
            String email,
            String tema,
            String msg,
            String arquivo){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        contactusInputName.sendKeys(name);
        contactusInputEmail.sendKeys(email);
        contactusInputTema.sendKeys(tema);
        js.executeScript("window.scrollBy(0, 500);");
        contactusTextArea.sendKeys(msg);
        contactusInputArquivo.sendKeys(arquivo);
        return this;
    }


                    //-- CLICKS --//
    public ContactUsPage clickBtnSubmitContacUs(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        contactusBtnSubmit.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
        return this;
    }
}
