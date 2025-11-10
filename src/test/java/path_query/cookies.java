package path_query;

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

public class cookies
{
    public String Cookie_value;

  //  @Test
    public void cookieDemo()
    {
        given()
                .when()
                    .get("https://www.google.com/")
                .then()
                .cookies("AEC","AaJma5sUFN6qqaF9uRURAt6EluEXX7yqwRyRDqgJ-DqKUbPJ8QFBEXcHss8")
                .log().all();
    }

    @Test(priority = 2)
    public void GetcookieInfo()
    {
       Response  res = given()
                .when()
                .get("https://www.google.com/");


       // single cookie info

//       String Cookie_value = res.getCookie("AEC");
//       System.out.println(Cookie_value);

        // get all cookies info



       Map<String,String> cookies_values = res.getCookies();

       //System.out.println(cookies_values);

       System.out.println(cookies_values.keySet());

       for(String k:cookies_values.keySet())
       {
           String Cookie_value = res.getCookie(k);
           System.out.println(k+"             " +Cookie_value);
       }
    }

}
