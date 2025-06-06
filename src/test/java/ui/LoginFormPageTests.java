package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pageObjects.LoginFormPage;

import static org.assertj.core.api.Assertions.assertThat;

class LoginFormPageTests extends BaseTest {
    @Test
    void loginFormTest() {
        LoginFormPage loginFormPage = new LoginFormPage(driver);
        loginFormPage.login();
        longWait.until(ExpectedConditions.urlContains("login-sucess"));

        assertThat(driver.getCurrentUrl()).contains("login-sucess");
    }
}
