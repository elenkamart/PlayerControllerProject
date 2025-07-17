package api.test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class NegativePlayerTests {
    @Test(priority = 1)
    public void createPlayerWithAdmin() {
        Response response =
                given()
                        .when()
                        .get("http://3.68.165.45/player/create/admin?age=59&gender=male&login=for%20test&password=berries123&role=user&screenName=testing")
                        .then()
                        .statusCode(403)
                        .log().all()
                        .extract().response();
    }

    @Test (priority = 2)
    public void getPlayerByPlayerId(){
        HashMap data = new HashMap();
        data.put("playerId", 3);
        Response response =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .post("http://3.68.165.45/player/get")
                        .then()
                        .statusCode(404)
                        .log().all()
                        .extract().response();
    }

    @Test (priority = 3)
    public void updatePlayerWithAdmin(){
        HashMap data = new HashMap();

        data.put("age", 43);
        data.put("gender", "female");
        data.put("login", "Wisorka");
        data.put("password", "blueberry");
        data.put("role", "admin");
        data.put("screenName", "Vip");
        Response response =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .patch("http://3.68.165.45/player/update/admin/16977800")
                        .then()
                        .statusCode(403)
                        .log().all()
                        .extract().response();
    }
    @Test (priority = 4)
    public void deletePlayer() {
        HashMap data = new HashMap();
        data.put("playerId", 1556429887);
        Response response =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .delete("http://3.68.165.45/player/delete/supervisor")
                        .then()
                        .statusCode(403)
                        .log().all()
                        .extract().response();
    }
}
