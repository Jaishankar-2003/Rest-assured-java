package response;

import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class parseJsonResponse
{
     /*

    @Test(priority = 1)
    public void testjsonresponse()
    {
        //approch

      given()
                .contentType("contentType.JSON")
                .when()
                .get("http://localhost:3000/students")
                .then()
                .statusCode(200)
                .header("Content-Type","application/json")
                .body("[0].email",equalTo("aarav.mehta@example.com"));

       */


        //Approach 2

/*
        Response res = given()
                .contentType("contentType.JSON")
                .when()
                .get("http://localhost:3000/students");
        Assert.assertEquals(res.getStatusCode(),200);
        Assert.assertEquals(res.getHeader("Content-Type"),"application/json");

       String name =  res.jsonPath().get("[0].email").toString();
       Assert.assertEquals(name,"aarav.mehta@example.com");

    }

 */
    @Test(priority = 2)

    public void testjsonresponseData()
    {

        Response res = given()
                .contentType("contentType.JSON")
                .when()
                .get("http://localhost:3000/students");


        //JSONobject class

        String responseBody = res.getBody().asString();

        // Convert to JSON Array since your data starts with [
        JSONArray arr = new JSONArray(responseBody);

        List<String> ids = IntStream.range(0, arr.length())
                .mapToObj(i -> arr.getJSONObject(i).optString("id"))
                .collect(Collectors.toList());

        System.out.println(ids);



    }






    }





