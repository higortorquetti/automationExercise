package Modulos.Testes;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.ContactUsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static Modulos.util.Constants.storeTestSiteBaseURL;

@DisplayName("Test contact US")
public class ContactUsTest {

    private WebDriver driver;

    @BeforeEach
    public void beforeEach() {
        this.driver = DriverFactory.getDriverFromString("CHROME");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.get(storeTestSiteBaseURL + "/contact_us");
    }

    @Test
    @DisplayName("Contact Us Form")
    public void testContactUsForm() {
        new ContactUsPage(driver)
                .verificaPaginaContactUs()
                .preencherDadosContacUs("zezinho",
                        "ze@zinho.com",
                        "testeContact",
                        "Test Contact",
                        "C:\\Users\\higor\\OneDrive\\Área de Trabalho\\CV_Higor Torquetti_ENG.docx")
                .clicaNoBotaoSubmit()
                .verificaMenssagemDeSucessoContatcUs()
                .clicaHomePage();
    }

    @AfterEach
    public void afterEach(){driver.quit();}
}
