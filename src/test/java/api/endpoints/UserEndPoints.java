package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

// Created for perform Create, Get, Update, Delete requests to the user API
public class UserEndPoints {

    public static Response getPlayerByPlayerId(String jasonBody, byte[] jsonBody) {
        io.restassured.specification.RequestSpecification given = given();
        given.contentType(ContentType.JSON);
        given.accept(ContentType.JSON);
        given.body(jsonBody);
        given.when();
        Response response = given
                .post(Routes.post_url);
        return response;
    }

    public static Response createUser(int age, String editor, String gender, String login, String password, String role, String screenName) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("age", age)
                .pathParam("editor", editor)
                .pathParam("gender", gender)
                .pathParam("login", login)
                .pathParam("password", password)
                .pathParam("role", role)
                .pathParam("screenName", screenName)
                .when()
                .get(Routes.get_url);
        return response;
    }

    public static Response getAllUsers() {
        Response response = given()
                .when()
                .get(Routes.get_all_url);
        return response;
    }

    public static Response updateUser(String username, User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .body(payload)
                .when()
                .patch(Routes.patch_url);
        return response;
    }

    public static Response deleteUser(String username) {
        Response response = given()
                .pathParam("username", username)
                .when()
                .delete(Routes.delete_url);
        return response;
    }
}
