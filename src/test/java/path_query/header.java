package path_query;

import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class header
{
    @Test
    public void headerDemo()
    {
        Response res = (Response) given()
                .when()
                .get("https://www.google.com/")

                .then()
                .assertThat()
                .header("Content-Type" ,"text/html; charset=ISO-8859-1")
                .and()
                .header("Server","gws")
                .and()
                .header("Content-Encoding","gzip")
                .extract()
                .response();

        String header = res.getHeader("Content-Type");
        System.out.println("content-type : " + header);

        Headers header_values = res.getHeaders();
        System.out.println(header_values);
    }

}
