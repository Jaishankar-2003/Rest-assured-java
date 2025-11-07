import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static jdk.jfr.internal.Logger.log;
import static org.hamcrest.Matchers.*;

public class local_server
{

    public static void main(String[] args)
    {

        // Base URL of your local API
        RestAssured.baseURI = "https://reques.in/api/";

            given()
                    .when()
                    .get("/users")
                    .then()
                    .statusCode(200);
                    //.log().body();





        // ------------------ POST A NEW STUDENT ------------------
//        System.out.println("---- CREATE NEW STUDENT ----");
//        String requestBody = """
//            {
//              j"id" : "5",
//              "name": "Best shankar",
//              "age": 25,
//              "gender": "Male",
//              "email": "jai.doe@example.com",
//              "course": "Cse Engineering",
//              "year": "Employee",
//              "marks": {
//                "maths": 81,
//                "physics": 75,
//                "chemistry": 78
//              },
//              "status": "active"
//            }
//            """;
//
//        Response postResponse = given()
//                .contentType(ContentType.JSON)
//                .body(requestBody)
//                .when()
//                .post("/students")
//                .then()
//                .statusCode(201)
//                .body("name", equalTo("Test shankar"))
//                .extract().response();

//        String studentId = postResponse.jsonPath().getString("id");
//        System.out.println("Created student ID: " + studentId);







        // ------------------ PATCH (UPDATE STUDENT) ------------------
//        System.out.println("---- UPDATE STUDENT ----");
//        String patchBody = """
//            {
//              "course": "Testing"
//            }
//            """;
//
//        given()
//                .contentType(ContentType.JSON)
//                .body(patchBody)
//                .when()
//                .patch("/students/d4fc")
//                .then()
//                .statusCode(200)
//                .body("course", equalTo("Testing"))
//                .log().body();




        // ------------------ DELETE STUDENT ------------------
//        System.out.println("---- DELETE STUDENT ----");
//        given()
//               .when()
//               .delete("/students/072d")
//               .then()
//               .statusCode(200); // JSON Server returns 200 for delete success

      //System.out.println("Student with ID " + studentId + " deleted successfully.");
    }

 }

