// java

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.http.ContentType;
import java.util.HashMap;

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
    public void createUser() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "private");
        data.put("job", "trainer");

        given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .statusCode(201)
            .log().all();
    }
}