// java

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static javax.swing.UIManager.getInt;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import java.util.HashMap;
import java.util.Map;
import java.util.prefs.Preferences;

public class day1
{

    @Test
    public void getUser() {
        given()
        .when()
            .get("https://reqres.in/api/users?page=2")
        .then()
            .statusCode(200)
            .body("page", equalTo(2))
            .log().all();
    }

    @Test
    public void createUser()
    {

        // Base URL
        RestAssured.baseURI = "https://reqres.in/api";

        // Request body
        String requestBody = """
            {
                "name": "morpheus",
                "job": "leader"
            }
            """;

        // Send POST request
        Response response =
                given()
                        .contentType(ContentType.JSON)
                        .body(requestBody)
                        .when()
                        .post("/users")
                        .then()
                        .statusCode(201)
                        .body("name", equalTo("morpheus"))
                        .body("job", equalTo("leader"))
                        .extract().response();

        // Print the entire response
        System.out.println("Response Body:");
        System.out.println(response.asPrettyString());

    }
}