package com.cydeo.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HrGetRequests {

    // BeforeAll is a annotation equals to qBeforeClass in testNG, we use with static method name
    @BeforeAll
    public static void init(){
        // save baseUrl inside this variable so that we dont need to type each http method.
        RestAssured.baseURI = "http://100.26.201.240:1000/ords/hr";//ords==> restAPI for database
    }

    @DisplayName("GET request to /regions")
    @Test
    public void test1(){
        Response response = RestAssured.get("/regions");

        // print the status code
        System.out.println(response.statusCode());
    }

    /*
        Given accept type is application/json
        When user sends get request to /regions/2
        Then response status code must be 200
        and content type equals to application/json
        and response body contains   Americas
     */

    @DisplayName("GET request to /regions/2")
    @Test
    public void test2(){
        Response response = given().accept(ContentType.JSON)
                .when()
                .get("/regions/2");

        //verify status code
        assertEquals(200,response.statusCode());
        //verify content type
        assertEquals("application/json",response.contentType());

        response.prettyPrint();

        //verify body contains Americas
        assertTrue(response.body().asString().contains("Americas"));

    }




}
