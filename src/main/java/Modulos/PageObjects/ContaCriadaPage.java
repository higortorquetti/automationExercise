package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContaCriadaPage extends WebBasePage {

    private WebDriver driver;
    @FindBy (css = "h2[data-qa=\"account-created\"]")
    private WebElement textAccCreateSucess;
    @FindBy (css = "a[data-qa=\"continue-button\"]")
    private WebElement BtnContinue;

    public ContaCriadaPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ContaCriadaPage verificaAcessoContaCriadaPage() {
            textAccCreateSucess.isDisplayed();
        return this;
    }

                        //-- CLICKS --//
    public HomePage clickBtnContinuar() {
        BtnContinue.click();
        return new HomePage(driver);
    }

}
