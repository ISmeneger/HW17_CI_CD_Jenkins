package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageTests extends BaseTest {
    @Test
    @DisplayName("Check HomePage page")
    void openHomePageTest() {
        HomePage homePage = new HomePage(driver);

        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }
}
