package ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pageObjects.HomePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageTests extends BaseTest {
    private static final String HOME_PAGE_TITLE = "Hands-On Selenium WebDriver with Java";

    @Test
    @DisplayName("Check HomePage page")
    void openHomePageTest() {
        HomePage homePage = new HomePage(driver);

        String actualTitle = homePage.getWebTitle();

        assertEquals(HOME_PAGE_TITLE, actualTitle);
    }
}
