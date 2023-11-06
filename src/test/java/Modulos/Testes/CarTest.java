package Modulos.Testes;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.ProdutosPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static Modulos.util.Constants.storeTestSiteBaseURL;

//S5: Cart
@DisplayName("Cart Test")
public class CarTest {

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
    public void testAddCarrinho(){

        String menssagem = new ProdutosPage(driver)
                .clicaBtnAddUmProduto()
                .capturaMenssagemAddProdutoCarrinho();

        Assertions.assertEquals("Your product has been added to cart.", menssagem);
    }

    //T2
    @Test
    @DisplayName("Adiciona X produtos no carrinho e verifica se a quantidade no carrinho esta correta.")
    public void testAddCarrinhoTestQntdProduto(){

                new ProdutosPage(driver)
                        .clicaBtnAddProdutoCarrinho(3)
                        .navegaCarPage()
                        .verificaAcessoCarPage()
                        .verificaProdutosCarrinho(3);
    }

    //T3
    @Test
    @DisplayName("Adiciona X quantidade de X produto e verifica se no carrinho esta correto")
    public void testAddCarrinhoTestQntd(){
            int qntdAtual = new ProdutosPage(driver)
                    .clicaBtnAddProdutoCarrinho(3)
                    .clicaBtnAddProdutoCarrinho(2)
                    .navegaCarPage()
                    .verificaProdutosCarrinho(3)
                    .verificaQuantidadeDeProdutos(5);

            Assertions.assertEquals(5, qntdAtual);


    }

    @AfterEach
    public void afterEach(){driver.quit();}
}
