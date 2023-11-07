package Modulos.Testes;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.LoginPage;
import Modulos.PageObjects.WebBasePage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

import static Modulos.util.Constants.*;

//S1: Login
@DisplayName("Login Test")
public class LoginTest{
    private WebDriver driver;
    @BeforeEach
    public void beforeEach() {
        this.driver = DriverFactory.getDriverFromString("CHROME");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.get(storeTestSiteBaseURL + "/login");
        }

    //T1
    @Test
    @DisplayName("Com credenciais válidas, faz o login e depois o Logout.")
    public void testLoginComCredenciaisValidasEntaoLogout(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            new LoginPage(driver)
                    .verificarAcessoLoginPage()
                    .setInputEmailLogin(emailLogin)
                    .setInputPasswordLogin(passwordLogin)
                    .clickBtnLogin()
                    .verificarSeEstaLogado()
                    .clickLogoutBtn();
    }

    //T2
    @Test
    @DisplayName("Fazer o Login com o email incorreto.")
    public void testLoginEmailIncorreto() {
        String emailErrorMessage = new LoginPage(driver)
                .verificarAcessoLoginPage()
                .setInputEmailLogin(emailInvaldo)
                .setInputPasswordLogin(passwordLogin)
                .clickBtnLoginInvalido()
                .getEmailErrorMessageLogin();

        Assertions.assertEquals(emailErrorMessageDefault, emailErrorMessage);
    }

    //T3
    @Test
    @DisplayName("Criar um novo usuário e exluir em seguida.")
    public void testCriarExcluirNovoUsuario(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new LoginPage(driver)
                .verificarAcessoLoginPage()
                .setInputNomeSignup(nomeSignup)
                .setInputEmailSignup(emailSignup)
                .clickBtnSignup()
                .verificaAcessoPaginaSignup()
                .setDataSignupForm(passwordSignup, daySignup, monthSignup, yearSignup,
                                    firstNameSignup, lastNameSignup, enderecoSignup, paisSignup,  estadoSignup
                                    , cidadeSignup, cepSignup, telefoneSignup)
                .clickBtnSignup()
                .verificaAcessoContaCriadaPage()
                .clickBtnContinuar()
                .verificarSeEstaLogado()
                .clickLinkDeleteAcc()
                .verificaAcessoContaExcluidaPage()
                .clickBtnContinuar();

    }

    //T4
    @Test
    @DisplayName("Registrar Usuário com email já existente")
    public void testEmailExistesSignup() {
        String menssagem = new LoginPage(driver)
                .verificarAcessoLoginPage()
                .setInputEmailSignup("ze@zinho.com")
                .setInputNomeSignup("zezinho")
                .clickBtnSignupInvalido()
                .getEmailErrorMessageSingup();

        Assertions.assertEquals("Email Address already exist!", menssagem);
    }

    @AfterEach
    public void afterEach(){driver.quit();}
}