package Modulos.Testes;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.ProdutosPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import static Modulos.util.Constants.*;


//S5: Cart
@DisplayName("Cart Test")
public class CartTest {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        this.driver = DriverFactory.getDriverFromString("CHROME");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.get(storeTestSiteBaseURL + "/products");
    }

    //T1
    @Test
    @DisplayName("Adiciona um produto ao carrinho.")
    public void testAddProdutoCarrinho(){

        String menssagem = new ProdutosPage(driver)
                .clickBtnAddProduto()
                .capturaMenssagemAddProdutoCarrinho();
        Assertions.assertEquals(productAddSucessMessage, menssagem);
    }

    //T2
    @Test
    @DisplayName("Adiciona X produtos no carrinho e verifica se a quantidade no carrinho esta correta.")
    public void testAddCarrinhoTestQntdProduto(){

                new ProdutosPage(driver)
                        .clickBtnAddProdutoCarrinho(3)
                        .acessaCartPage()
                        .verificaAcessoCartPage()
                        .verificaProdutosCarrinho(3);
    }

    //T3
    @Test
    @DisplayName("Adiciona X quantidades de X produtos e verifica se no carrinho esta correto")
    public void testAddCarrinhoQntd(){
            int qntdAtual = new ProdutosPage(driver)
                    .clickBtnAddProdutoCarrinho(3)
                    .clickBtnAddProdutoCarrinho(2)
                    .acessaCartPage()
                    .verificaProdutosCarrinho(3)
                    .verificaQuantidadeDeCadaProduto();

            Assertions.assertEquals(5, qntdAtual);


    }

    @AfterEach
    public void afterEach(){driver.quit();}
}
