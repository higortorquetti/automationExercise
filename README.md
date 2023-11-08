# Projeto de Testes - Automação GUI test com Selenium WebDriver
Este é parte do meu aprendizado com Selenium WebDriver.</br>
Para todos os teste vou usar o site [automation testes](https://automationexercise.com/) que é próprio para treinar automação.

***
### 👨🏻‍💻 Stack de Tecnologias
- Programming language - **Java (JDK 19)**
- Automation framework - **Selenium WebDriver** 
- Project management tool - **Maven**
- Testing Framework - **JUnit** 

#### 🎨 Design Patterns:
- **Page Object Model**
- **Fluent Page** 
- **PageFactory**
- **DriverFactory** 

***
### 🧪 Testes:
- **S1: Login**  
  **T1:** Login e Logout com usuario valido.  
  **T2:** Login usando email incorreto.</br>
  **T3:** Criar um novo usuario e exclui em seguida. </br>
  **T4:** Registrar novo usuario com email já existente.

- **S2: Contact Us**  
  **T1:** Enviar um formluario de contato.

- **S3:** Product</br>
  **T1:** Verifica fluxo de pagina de produtos para pagina de produto detalhado.</br>
  **T2:** Verifica se os produtos estão sendo buscados na pagina de produtos.

- **S4:** Home</br>
  **T1:** Verifica o fluxo de inscrição no site atraés de email.

- **S5** Cart</br>
  **T1:** Verifica se os produtos estão sendo inseridos no carrinho com sucesso</br>
  **T2:** Inseri X produtos no carrinho e verifica se a quantidade no carrinho é igual a inserida</br>
  **T3** Inseri X produtos e X quantidade e verifica se a quantidade de cada produto é igual a esperada
