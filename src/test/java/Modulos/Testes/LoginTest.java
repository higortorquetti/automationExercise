package Modulos.Testes;

import Modulos.Driver.DriverFactory;
import Modulos.PageObjects.HomePage;
import Modulos.PageObjects.LoginPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static Modulos.util.Constants.*;
import static java.sql.DriverManager.getDriver;


@DisplayName("Login Test")
public class LoginTest {
    private WebDriver driver;
    @BeforeEach
    public void beforeEach() {
        this.driver = DriverFactory.getDriverFromString("CHROME");
        this.driver.manage().window().maximize();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.get(storeTestSiteBaseURL + "/login");
        }

    @Test
    @DisplayName("Com credenciais válidas, faz o login e depois o Logout.")
    public void testoginComCredenciaisValidasEntaoLogout(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            new LoginPage(driver)
                    .verificarAcessoLoginPage()
                    .inserirEmailLogin(email)
                    .inserirSenhaLogin(password)
                    .clicaNoBotaoDeLogin()
                    .verificarSeEstaLogado()
                    .clicaNoBotaoLogout()
                    .verificarAcessoLoginPage();
    }
    @Test
    @DisplayName("Fazer o Login com o email incorreto.")
    public void testLoginEmailIncorreto() {
        String emailIncorreto = new LoginPage(driver)
                .verificarAcessoLoginPage()
                .inserirEmailLogin("ze@zinh")
                .inserirSenhaLogin("123456789")
                .clicaNoBotaoDeLoginEmailErrado()
                .capturaMenssagemEmailIncorreto();

        Assertions.assertEquals("Your email or password is incorrect!", emailIncorreto);
    }
    @Test
    @DisplayName("Criar um novo usuário e exluir em seguida.")
    public void testCriarExcluirNovoUsuario(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        new LoginPage(driver)
                .verificarAcessoLoginPage()
                .inserirNomeSignup("zezinho")
                .inserirEmailSignup("zezinho@ze.com")
                .clicaBtnSigupPage()
                .verificaAcessoPaginaSignup()
                .preencherDadosSignup("123456789",
                        18, 6, 2012,
                        "Zezinho", "Silv Silva",
                        "Rua dos bobos, numero 0",
                        "SP","Bauru", "159874652",
                        "999555888"
                )
                .clicaNoBotaoSignup()
                .acessoPaginaContaCriadaSucesso()
                .clicaNoBotaoContinuar()
                .verificarSeEstaLogado()
                .excluirContaNovoUsuario()
                .verificaPaginaContaExcluida()
                .clicaNoBotaoContinuar();

    }
    @Test
    @DisplayName("Registrar Usuário com email já existente")
    public void testEmailExistesSignup() {
        String menssagem = new LoginPage(driver)
                .verificarAcessoLoginPage()
                .inserirEmailSignup("ze@zinho.com")
                .inserirNomeSignup("zezinho")
                .clicarNoBotaoSignupEmailExistente()
                .capturaMenssagemEmailExistente();

        Assertions.assertEquals("Email Address already exist!", menssagem);
    }

    @AfterEach
    public void afterEach(){driver.quit();}
}