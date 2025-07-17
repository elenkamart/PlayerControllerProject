package api.test;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PlayerTests {

   @Test(priority = 1)
    public void createPlayer() {
       Response response =
given()
        .when()
        .get("http://3.68.165.45/player/create/supervisor?age=59&gender=male&login=delete&password=berries123&role=admin&screenName=testingdelete")
        .then()
        .statusCode(200)
        .log().all()
        .extract().response();
   }

    @Test (priority = 2)
public void getPlayerByPlayerId(){
    HashMap data = new HashMap();
    data.put("playerId", "1");
    Response response =
            given()
                    .contentType("application/json")
                    .body(data)
                    .when()
                    .post("http://3.68.165.45/player/get")
                    .then()
                    .statusCode(200)
                    .log().all()
                    .extract().response();
}

    @Test(priority = 3)
    public void getAllPlayers() {
        given()
                .when()
                .get("http://3.68.165.45/player/get/all")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }
    @Test (priority = 4)
    public void updatePlayer(){
        HashMap data = new HashMap();

        data.put("age", "43");
        data.put("gender", "female");
        data.put("login", "berries");
        data.put("password", "blueberry");
        data.put("role", "admin");
        data.put("screenName", "green");
        Response response =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
                        .patch("http://3.68.165.45/player/update/supervisor/1032281750")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract().response();
    }
    @Test (priority = 5)
    public void deletePlayer() {
        HashMap data = new HashMap();
        data.put("playerId", "1556429887");
        Response response =
                given()
                        .contentType("application/json")
                        .body(data)
                        .when()
               .delete("http://3.68.165.45/player/delete/supervisor")
               .then()
               .statusCode(204)
               .log().all()
         .extract().response();
    }
}
//@Test(priority = 1)
//public void createPlayer() {
//        String jsonBody = "{\"age\":\"35\",\"gender\":\"female\",\"login\":turkey\",\"password\":\"turkey23\",\"role\":\"supervisor\",\"screenName\":\"bomba67\"}";
//        Response response = given().spec(requestSpecification())
//                .body(jsonBody)
//                .when().post("getPlayerByPlayerId")
//                .then().assertThat().statusCode(404)
//                .header("Content-Type", "application/json")
//                .header("Cache-Control", "max-age=3600")
//                .body("editor", equalTo("supervisor"))
//                .time(lessThan(5000L))
//                .extract().response();
//
//
//        response.then().log().all();
//        Assert.assertEquals(response.getStatusCode(), 200);

