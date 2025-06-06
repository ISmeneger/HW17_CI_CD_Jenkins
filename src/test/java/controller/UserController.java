package controller;

import configs.TestPropertiesConfig;
import io.qameta.allure.Step;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.User;
import org.aeonbits.owner.ConfigFactory;

import static io.restassured.RestAssured.given;

public class UserController {
    RequestSpecification requestSpecification = given();
    TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    public UserController() {
        requestSpecification.baseUri(configProperties.getApiBaseUrl());
        requestSpecification.accept("application/json");
        requestSpecification.contentType("application/json");
        requestSpecification.filter(new AllureRestAssured());
    }

    @Step("Create user")
    public Response createUser(User user) {
        requestSpecification.body(user);
        return given(requestSpecification).when().post("user");
    }

    @Step("Update user")
    public Response updateUser(User user, String username ) {
        requestSpecification.body(user);
        return given(requestSpecification).when().put("user/" + username);
    }

    @Step("Get user by username")
    public Response getUser(String username) {
        return given(requestSpecification).when().get("user/" + username);
    }

    @Step("Delete user by username")
    public Response deleteUserByUserName(String username) {
        return given(requestSpecification).when().delete("user/" + username);
    }
}
