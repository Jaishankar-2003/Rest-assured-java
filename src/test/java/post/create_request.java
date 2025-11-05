package post;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class create_request
{

        // post request

//        1.hash mamp
//        2 using org.json
//        3 use pojo (plain old java object) in separate class
//        4 use external json file

/*
        @Test
        void testpost_has() // use these while less data for test
        {

            HashMap data = new HashMap<>();

            data.put("name" , "muscut");
            data.put("age" , "22");
            data.put("gender" , "male");
            data.put("email" , "adadai@gmail.com");
            data.put("year" , "first");

            given()
                    .contentType("application/json")
                    .body(data)
            .when()
                    .post("http://localhost:3000/students")
            .then()
                    .statusCode(201)
                    .body("name",equalTo("muscut"))
                    .header("X-Powered-By","tinyhttp")
                    .log().all();

        }

 */

//----------------------------------------------------------------------------------------------------------

/*
    @Test(priority = 1)
    void testpost_orgjson()
    {

        JSONObject data = new JSONObject();

        data.put("id","5");
        data.put("name","ramasamy");
        data.put("age","32");
        data.put("gender","male");
        data.put("year","2003");

        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                //.body("name",equalTo("ramasamy"))
                .header("X-Powered-By","tinyhttp")
                .log().all();

    }
 */
//---------------------------------------------------------------------------------------------------------------

/*

  //  pojo method

    @Test(priority = 1)
    void testpost_pojo()
    {

        pojo_post data = new pojo_post();

        data.setId("6");
        data.setName("imta");
        data.setAge("34");
        data.setGender("male");
        data.setYear("1991");

        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                //.body("name",equalTo("ramasamy"))
                .header("X-Powered-By","tinyhttp")
                .log().all();

    }

 */

//---------------------------------------------------------------------------------------------------------------------


    @Test(priority = 1)
    void testpost_external_json() throws FileNotFoundException {

        File f = new File("./body.json");

        System.out.println("Resolved path: " + f.getAbsolutePath());
        FileReader fr = new FileReader(f);

        JSONTokener jt = new JSONTokener(fr);

        JSONObject data = new JSONObject(jt);



        given()
                .contentType("application/json")
                .body(data.toString())
                .when()
                .post("http://localhost:3000/students")
                .then()
                .statusCode(201)
                //.body("name",equalTo("ramasamy"))
                .header("X-Powered-By","tinyhttp")
                .log().all();

    }










//    @Test(priority = 2)
//        void testdelete()
//        {
//            given()
//                    .when()
//                    .delete("http://localhost:3000/students/6")
//                    .then()
//                    .statusCode(200);
//        }




}