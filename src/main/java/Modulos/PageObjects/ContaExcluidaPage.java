package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContaExcluidaPage extends WebBasePage{
    
    private WebDriver driver;
    @FindBy (css = "h2[data-qa=\"account-deleted\"] b")
    private WebElement textAccDeleted;
    @FindBy (css = "a[data-qa=\"continue-button\"]")
    private WebElement btnContinuar;
    public ContaExcluidaPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ContaExcluidaPage verificaAcessoContaExcluidaPage(){
        textAccDeleted.isDisplayed();
        return this;
    }

                        //-- CLICKS EM BOTÕES --//
    public HomePage clickBtnContinuar() {
        btnContinuar.click();
        return new HomePage(driver);
    }
}
