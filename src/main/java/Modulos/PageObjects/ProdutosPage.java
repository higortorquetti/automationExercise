package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProdutosPage {
    private WebDriver driver;
    public ProdutosPage(WebDriver driver){this.driver = driver;}

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ProdutosPage verificaAcessoProdutosPageAllProducts() {
        WebElement elemento = driver.findElement(By.cssSelector("div > h2[class=\"title text-center\"]"));
        String textoAllProducts = elemento.getText().toUpperCase();
        textoAllProducts.equals("ALL PRODUTCS");
        return this;
    }
    public String verificaAcessoProdutosPageSearchProducts() {
        WebElement elemento = driver.findElement(By.cssSelector("div > h2[class=\"title text-center\"]"));
        String textoAllProducts = elemento.getText().toUpperCase();
        return textoAllProducts;
    }

                    //-- INSERÇÃO DE DADOS --//
    public ProdutosPage inseriValorPesquisa(String pesquisa){
        driver.findElement(By.cssSelector("input[id=\"search_product\"]")).sendKeys(pesquisa);

        return this;
    }

                    //-- CLICKS EM BOTÕES --//
    public ProductDetailPage clicaBtnViewProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.cssSelector("li a[href=\"/product_details/1\"]")).click();

        return new ProductDetailPage(driver);
    }
    public ProdutosPage clicaBtnPesquisa(){
        driver.findElement(By.cssSelector("button[id=\"submit_search\"]")).click();

        return this;
    }
}
