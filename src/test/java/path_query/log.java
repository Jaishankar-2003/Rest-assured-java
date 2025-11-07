package path_query;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class log
{
    @Test
    public void testlog()
    {
        given()
                .when()
                .get("https://reqres.in/api/users")
                .then()
               // .log().all()
               // .log().body()
                //.log().cookies()
                  .log().headers();
    }

}
