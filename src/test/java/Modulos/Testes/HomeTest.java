package Modulos.Testes;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.HomePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import java.time.Duration;
import static Modulos.util.Constants.*;

//S4
@DisplayName("Testes da pagina Home")
public class HomeTest {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        this.driver = DriverFactory.getDriverFromString("CHROME");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.get(storeTestSiteBaseURL);
    }

    //T1
    @Test
    @DisplayName("Verifica a inscrição da pagina home")
    public void verificaInscricaoHome(){
        String menssagemSucesso = new HomePage(driver)
                .verificaAcessoPaginaHome()
                .subscriptionEmail(emailSignup)
                .clickBtnSubscribe()
                .getSubscribeSucecssMessage();

        Assertions.assertEquals(subscribeSucessMessage, menssagemSucesso);

    }

    @AfterEach
    public void afterEach(){driver.quit();}
}
