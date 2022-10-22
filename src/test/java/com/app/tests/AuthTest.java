package com.app.tests;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class AuthTest {


   // @Test
    public void BasicAuthTest()
    {

        Response response = given()
                .auth()
                .basic("postman", "password")
                .log()
                .all()
                .get("https://postman-echo.com/basic-auth");
         response.prettyPrint();
    }
   // @Test
    public void BasicAuthTest1()
    {

        Response response = given()
                .header("Authorization","Basic cG9zdG1hbjpwYXNzd29yZA==")
                .log()
                .all()
                .get("https://postman-echo.com/basic-auth");
        response.prettyPrint();
    }
}
