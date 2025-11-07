package path_query;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class path_and_query_parameter
{
    @Test
    void testQueryandParameters()
    {
        given()
                .pathParams("mypath","booking")  //path parameter
                .pathParams("num","1")  //path parameter
                //.queryParam("page" , 2) //query param
                //.queryParam("id",5) //query param
                .when()
                    .get("https://restful-booker.herokuapp.com/{mypath}/{num}")
                .then()
                .statusCode(200)
                .log().all();
    }
}
