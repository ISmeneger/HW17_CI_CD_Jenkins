package api;

import controller.UserController;
import io.restassured.response.Response;
import models.AddUserResponse;
import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static constants.CommonConstants.*;
import static constants.CommonConstants.DEFAULT_USER;

class UserTests {
    @Test
    void createUserTest() {
        UserController userController = new UserController();

        Response response = userController.createUser(DEFAULT_USER);
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(200, createdUserResponse.getCode());
        Assertions.assertEquals("unknown", createdUserResponse.getType());
        Assertions.assertFalse(createdUserResponse.getMessage().isEmpty());
    }

    @Test
    void updateUserTest() {
        String username = "string2";

        UserController userController = new UserController();

        Response response = userController.updateUser(UPDATE_USER, username);

        Assertions.assertEquals(200, response.getStatusCode());
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class);
        Assertions.assertEquals(200, createdUserResponse.getCode());
        Assertions.assertEquals("unknown", createdUserResponse.getType());
        Assertions.assertEquals("1", createdUserResponse.getMessage());
    }

    @Test
    void getUserTest() {
        UserController userController = new UserController();

        Response response = userController.getUser("string");

        Assertions.assertEquals(200, response.getStatusCode());
        User user = response.as(User.class);
        Assertions.assertTrue(user.getId() > 9223372036854766000L);
        Assertions.assertEquals(expectedUser, user);
    }

    @Test
    void createUserWithSerializationTest() {
        UserController userController = new UserController();

        Response response = userController.createUser(DEFAULT_USER);
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class);

        Assertions.assertEquals(200, response.getStatusCode());
        Assertions.assertEquals(200, createdUserResponse.getCode());
        Assertions.assertEquals("unknown", createdUserResponse.getType());
        Assertions.assertFalse(createdUserResponse.getMessage().isEmpty());
    }

    @Test
    void deleteUserTest() {
        UserController userController = new UserController();

        Response response = userController.deleteUserByUserName("string");

        Assertions.assertEquals(200, response.getStatusCode());
        AddUserResponse createdUserResponse = response.as(AddUserResponse.class);
        Assertions.assertEquals(200, createdUserResponse.getCode());
        Assertions.assertEquals("unknown", createdUserResponse.getType());
        Assertions.assertEquals("string", createdUserResponse.getMessage());
    }
}
