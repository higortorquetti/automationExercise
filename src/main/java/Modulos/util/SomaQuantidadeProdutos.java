package Modulos.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SomaQuantidadeProdutos {
    private static WebDriver driver;

    public SomaQuantidadeProdutos(WebDriver driver){this.driver = driver;}

    public static int getCartTotalQuantity() {
        int totalQuantity = 0;
        List<WebElement> quantityElements = driver.findElements(By.cssSelector("td[class=\"cart_quantity\"]"));

        for (WebElement quantityElement : quantityElements) {
            int productQuantity = Integer.parseInt(quantityElement.getText());
            totalQuantity += productQuantity;
        }

        return totalQuantity;
    }
}
