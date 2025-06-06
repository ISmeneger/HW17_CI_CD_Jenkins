package constants;

import models.User;

public class CommonConstants {
    public static final String BASE_URI = "https://petstore.swagger.io/v2/";
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    public static final User DEFAULT_USER = new User(0, "string", "string","string","string","string","string", 0);

    public static final User expectedUser = new User(9223372036854767000L, "string", "string","string","string","string","string", 0);

    public static final User UPDATE_USER = new User(1, "string2", "string2","string2","string2","string2","string2", 1);
}
