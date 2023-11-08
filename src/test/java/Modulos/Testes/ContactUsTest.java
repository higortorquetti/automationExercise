package Modulos.Testes;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.ContactUsPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

import static Modulos.util.Constants.*;

//S2: Contact Us
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
    //T1
    @Test
    @DisplayName("Contact Us Form")
    public void testContactUsForm() {
        new ContactUsPage(driver)
                .verificaPaginaContactUs()
                .setDataContatcUsForm(firstNameSignup,
                        emailLogin,
                        contactUsTema,
                        contactUsMenssage,
                        caminhoArquivo)
                .clickBtnSubmitContacUs()
                .verificaMenssagemDeSucessoContatcUs();
    }

    @AfterEach
    public void afterEach(){driver.quit();}
}
