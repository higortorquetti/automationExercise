package Modulos.PageObjects;


import Modulos.util.SomaQuantidadeProdutos;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {this.driver = driver;}

    public CartPage verificaAcessoCarPage(){
            driver.findElement(By.cssSelector("li[class=\"active\"]")).isDisplayed();
        return this;
    }

    public CartPage verificaProdutosCarrinho(int qntdprodutos) {
        List<WebElement> productRows = driver.findElements(By.cssSelector("tr[id^=\"product-\"]"));
        int totalProducts = productRows.size();

        if (totalProducts == qntdprodutos) {
            System.out.println("O numero de produtos é igual a quantidade esperada");
        } else {
            System.out.println("O numero de produtos não é igual a quantidade esperada");
        }
        return this;
    }

    public int verificaQuantidadeDeProdutos(int qntEsperada){
        new SomaQuantidadeProdutos(driver);
        int qntdAtual = SomaQuantidadeProdutos.getCartTotalQuantity();

        return qntdAtual;
    }


}
