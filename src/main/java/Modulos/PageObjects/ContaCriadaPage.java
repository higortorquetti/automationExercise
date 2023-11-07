package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ContaCriadaPage {

    private WebDriver driver;
    @FindBy (css = "h2[data-qa=\"account-created\"]")
    private WebElement textAccCreateSucess;
    @FindBy (css = "a[data-qa=\"continue-button\"]")
    private WebElement BtnContinue;

    public ContaCriadaPage(WebDriver driver){this.driver = driver;
        PageFactory.initElements(driver, this);
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ContaCriadaPage verificaAcessoContaCriadaPage() {
            textAccCreateSucess.isDisplayed();
        return this;
    }

                        //-- CLICKS EM BOTÕES --//
    public HomePage clickBtnContinuar() {
        BtnContinue.click();
        return new HomePage(driver);
    }

}
