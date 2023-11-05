package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    private WebDriver driver;

    public CartPage(WebDriver driver) {this.driver = driver;}

    public CartPage verificaAcessoCarPage(){
            driver.findElement(By.cssSelector("li[class=\"active\"]")).isDisplayed();
        return this;
    }

    public CartPage verificaQntdProdutos(int qntdprodutos){
        for (int i = 1; i < qntdprodutos; i++ ){
            driver.findElement(By.cssSelector("tr[id=\"product-" + i + "\"]")).isDisplayed();
        }
        return this;
    }

}
