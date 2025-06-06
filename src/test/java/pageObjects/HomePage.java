package pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static constants.CommonConstants.BASE_URL;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    //actions
    @Step("Open homepage")
    private void open() {
        driver.get(BASE_URL);
    }

    @Step("Get web title")
    public String getWebTitle() {
        return driver.getTitle();
    }

    //method -> open another Page Object
    @Step("Open Web form page")
    public WebFormPage openWebFormPage() {
        driver.findElement(By.linkText("Web form")).click();
        return new WebFormPage(driver);
    }
}
