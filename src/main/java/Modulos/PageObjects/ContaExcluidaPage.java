package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContaExcluidaPage extends WebBasePage{
    
    private WebDriver driver;
    @FindBy (css = "h2[data-qa=\"account-deleted\"] b")
    private WebElement contaDeletaSucessoText;
    @FindBy (css = "a[data-qa=\"continue-button\"]")
    private WebElement contaDeletadaSucessoBtn;
    public ContaExcluidaPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ContaExcluidaPage verificaAcessoContaExcluidaPage(){
        contaDeletaSucessoText.isDisplayed();
        return this;
    }

                        //-- CLICKS EM BOTÕES --//
    public HomePage clickBtnContinuar() {
        contaDeletadaSucessoBtn.click();
        return new HomePage(driver);
    }
}
