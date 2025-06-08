package pageObjects;

import configs.TestPropertiesConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    public HomePage(WebDriver driver) {
        super(driver);
        open();
    }

    //actions
    @Step("Open homepage")
    private void open() {
        driver.get(configProperties.getUiBaseUrl());
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
