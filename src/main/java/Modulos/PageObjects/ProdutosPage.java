package Modulos.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ProdutosPage extends WebBasePage {
    private WebDriver driver;
    @FindBy (css = "div > h2[class=\"title text-center\"]")
    private WebElement productTextTitle;
    @FindBy (css = "div > h2[class=\"title text-center\"]")
    private WebElement productTextSearched;
    @FindBy (css = "input[id=\"search_product\"]")
    private WebElement productInputSearch;
    @FindBy (css = "button[id=\"submit_search\"]")
    private WebElement productBtnPesquisa;
    @FindBy (css = "li a[href=\"/product_details/1\"]")
    private WebElement productAddProductLink;
    @FindBy (css = "div[class=\"productinfo text-center\"]")
    private WebElement product;
    @FindBy (css = "a[data-product-id=\"1\"]")
    private WebElement productBtnAdd;
    @FindBy (css = "button[data-dismiss=\"modal\"]")
    private WebElement productBtnSucessAlert;
    @FindBy (css = "p[class=\"text-center\"]")
    private WebElement productTextAddSucess;

    public ProdutosPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

                    //-- VERIFICAÇÕES DE PAGINA --//
    public ProdutosPage verificaAcessoProdutos() {
        if (!productTextTitle.getText().toUpperCase().equals("ALL PRODUCTS")){
            throw new RuntimeException();
        };
        return this;
    }
    public ProdutosPage verificaAcessoProdutosPageSearchProducts() {
        if (!productTextSearched.getText().toUpperCase().equals("SEARCHED PRODUCTS")){
            throw new RuntimeException();
        }
        return this;
    }

                    //-- INSERÇÃO DE DADOS --//
    public ProdutosPage setValorPesquisa(String pesquisa){
        productInputSearch.sendKeys(pesquisa);
        return this;
    }


                        //-- CLICKS --//
    public ProdutosPage clickBtnAddProdutoCarrinho(int qntdprodutos){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0 ,500);");

        for (int i = 1; i <= qntdprodutos; i++){
            WebElement product = driver.findElement(By.cssSelector("div[class=\"productinfo text-center\"]"));
            Actions actions = new Actions(driver);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
            actions.moveToElement(product).click().perform();

            WebElement addButton = driver.findElement(By.cssSelector("a[data-product-id=\""+i+"\"]"));
            addButton.click();
            clickBtnAddProdutoSucessAlert();
        }
        return this;
    }
    public ProductDetailPage clickBtnViewProduct(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 500);");
        productAddProductLink.click();

        return new ProductDetailPage(driver);
    }
    public CartPage acessaCartPage(){
            driver.findElement(By.cssSelector("a[href=\"/view_cart\"]")).click();

        return new CartPage(driver);
    }
    public ProdutosPage clickBtnPesquisa(){
        productBtnPesquisa.click();
        return this;
    }
    public ProdutosPage clickBtnAddProdutoSucessAlert(){
        productBtnSucessAlert.click();
        return this;
    }
    public ProdutosPage clickBtnAddProduto(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", product);
        actions.moveToElement(product).click().perform();
        productBtnAdd.click();
        return this;
    }


                    //-- CAPTURA MENSSAGEN --//
    public String capturaMenssagemAddProdutoCarrinho(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.visibilityOf(productTextAddSucess));
        return productTextAddSucess.getText();
    }
}
