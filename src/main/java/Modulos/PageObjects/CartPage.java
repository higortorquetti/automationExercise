package Modulos.PageObjects;


import Modulos.util.SomaQuantidadeProdutos;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
public class CartPage  extends WebBasePage {
    private WebDriver driver;
    @FindBy (css = "li[class=\"active\"]")
    private WebElement cartText;
    @FindBy (css = "tr[id^=\"product-\"]")
    private List<WebElement> cartProductRows;
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public CartPage verificaAcessoCartPage(){
            cartText.isDisplayed();
        return this;
    }
    public CartPage verificaProdutosCarrinho(int qntdprodutos) {
        if ( qntdprodutos != cartProductRows.size()) {
            throw new IllegalStateException("Quantidade de produtos diferente da esperada!");
        }
        return this;
    }
    public int verificaQuantidadeDeCadaProduto(){
        new SomaQuantidadeProdutos(driver);
        int qntdAtual = SomaQuantidadeProdutos.getCartTotalQuantity();
        return qntdAtual;
    }

}
