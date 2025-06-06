package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    protected WebDriver driver;

    //locators
    By title = By.className("display-6");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Getting current url")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Get subpage title")
    public WebElement getTitle() {
        return driver.findElement(title);
    }
}
