package Modulos.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class WebBasePage {
    protected WebDriver driver;
    public WebBasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }
}
