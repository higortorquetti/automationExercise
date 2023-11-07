package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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


                        //-- CLICKS --//
    public ProdutosPage clicaBtnAddProdutoCarrinho(int qntdprodutos){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0 ,500);");

        for (int i = 1; i <= qntdprodutos; i++){
            WebElement product = driver.findElement(By.cssSelector("div[class=\"productinfo text-center\"]"));
            Actions actions = new Actions(driver);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
            actions.moveToElement(product).click().perform();

            WebElement addButton = driver.findElement(By.cssSelector("a[data-product-id=\""+i+"\"]"));
            addButton.click();
            clicaBtnAddProdutoSucesso();
        }
        return this;
    }
    public ProductDetailPage clicaBtnViewProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        driver.findElement(By.cssSelector("li a[href=\"/product_details/1\"]")).click();

        return new ProductDetailPage(driver);
    }
    public CartPage navegaCarPage(){
            driver.findElement(By.cssSelector("a[href=\"/view_cart\"]")).click();

        return new CartPage(driver);
    }
    public ProdutosPage clicaBtnPesquisa(){
        driver.findElement(By.cssSelector("button[id=\"submit_search\"]")).click();

        return this;
    }
    public ProdutosPage clicaBtnAddProdutoSucesso(){
        driver.findElement(By.cssSelector("button[data-dismiss=\"modal\"]")).click();

        return this;
    }
    public ProdutosPage clicaBtnAddUmProduto(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0 ,500);");
        WebElement product = driver.findElement(By.cssSelector("div[class=\"productinfo text-center\"]"));
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
        actions.moveToElement(product).click().perform();

        WebElement addButton = driver.findElement(By.cssSelector("a[data-product-id=\"1\"]"));
        addButton.click();
        return this;
    }


                    //-- CAPTURA MENSSAGEN --//
    public String capturaMenssagemAddProdutoCarrinho(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        WebElement menssagem = wait.until(ExpectedConditions
                .visibilityOfElementLocated(By
                        .cssSelector("p[class=\"text-center\"]")));
        return menssagem.getText();
    }
}
