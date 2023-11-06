package Modulos.Testes;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.ProdutosPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static Modulos.util.Constants.storeTestSiteBaseURL;

//S3: Product
@DisplayName("Todos Produtos Test")
public class ProductsTest {

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
    @DisplayName("Verifica pagina de todos produtos e pagina de produto detalhado")
    public void verificaTodosProdutosDetalhesProdutos(){
        new ProdutosPage(driver)
                .verificaAcessoProdutosPageAllProducts()
                .clicaBtnViewProduct()
                .verificaProdutoDetail();
    }

    //T2
    @Test
    @DisplayName("Verifica pagina de produtos buscados")
    public void buscaDeProdutos(){
        String produtoBusca = new ProdutosPage(driver)
                .verificaAcessoProdutosPageAllProducts()
                .inseriValorPesquisa("Blue")
                .clicaBtnPesquisa()
                .verificaAcessoProdutosPageSearchProducts();

        Assertions.assertEquals("SEARCHED PRODUCTS", produtoBusca);

    }
    @AfterEach
    public void afterEach(){driver.quit();}
}
