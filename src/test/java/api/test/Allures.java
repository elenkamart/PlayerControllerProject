package api.test;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.http.ContentType;
import org.json.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@Epic("REST API Testing using TestNG")
@Feature("Verify CRUID Operations on User module")

public class Allures {
    @Test(description = "To get the details of user with id 1", priority = 0)
    @Story("GET Request with Valid User")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description : Verify the details of user of id-1")
    public void verifyUser() {
        JSONObject data = new JSONObject();

        data.put("playerId", 1);

        // Given
        given()

                .filter(new AllureRestAssured())
                .contentType(ContentType.JSON)
                .body(data.toString())
                // When
                .when()
                .post("http://3.68.165.45/player/get")

                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")
                // To verify user of id 1
                .body("id", equalTo(1))
                .body("login", equalTo("supervisor"))
                .body("password", equalTo("string"))
                .body("screenName", equalTo("testSupervisor"))
                .body("gender", equalTo("male"))
                .body("age", equalTo(17))
                .body("role", equalTo("supervisor"))
                .log().all()
                .extract().response();
    }
    @Test
    public void createUser() {
        // Given
        given()

                .filter(new AllureRestAssured())
                // When
                .when()
                .get("http://3.68.165.45/player/create/supervisor?age=20&gender=female&login=green&password=white&role=admin&screenName=pumpkin")

                // Then
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 ")

                .body("id", equalTo(957390786))
                .body("login", equalTo("green"))
                .body("password", equalTo(null))
                .body("screenName", equalTo(null))
                .body("gender", equalTo(null))
                .body("age", equalTo(null))
                .body("role", equalTo(null))
                .log().all()
                .extract().response();
    }
    }


