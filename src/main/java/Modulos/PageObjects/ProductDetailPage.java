package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends WebBasePage {

    private WebDriver driver;
    @FindBy (css = "div[class=\"product-details\"]")
    private WebElement produtoDetalhes;
    public ProductDetailPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ProductDetailPage verificaProdutoDetail(){
        produtoDetalhes.isDisplayed();
        return this;
    }

}
