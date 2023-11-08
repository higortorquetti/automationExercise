package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class ContaCriadaPage extends WebBasePage {

    private WebDriver driver;
    @FindBy (css = "h2[data-qa=\"account-created\"]")
    private WebElement contaCriadaSucessoText;
    @FindBy (css = "a[data-qa=\"continue-button\"]")
    private WebElement contaCriadaSucessoBtnContinue;

    public ContaCriadaPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ContaCriadaPage verificaAcessoContaCriadaPage() {
            contaCriadaSucessoText.isDisplayed();
        return this;
    }

                        //-- CLICKS --//
    public HomePage clickBtnContinuar() {
        contaCriadaSucessoBtnContinue.click();
        return new HomePage(driver);
    }

}
