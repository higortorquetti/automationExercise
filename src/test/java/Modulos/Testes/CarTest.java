package Modulos.Testes;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.ProdutosPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static Modulos.util.Constants.storeTestSiteBaseURL;

@DisplayName("Car Test")
public class CarTest {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        this.driver = DriverFactory.getDriverFromString("CHROME");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.get(storeTestSiteBaseURL + "/products");
    }

    @Test
    @DisplayName("Adiciona um produto ao carrinho.")
    public void testAddCarrinho(){

        String menssagem = new ProdutosPage(driver)
                .clicaBtnAddCarrinho()
                .capturaMenssagemAddProdutoCarrinho();

        Assertions.assertEquals("Your product has been added to cart.", menssagem);
    }
    @AfterEach
    public void afterEach(){driver.quit();}
}
