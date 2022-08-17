package com.cydeo.apiShorts.apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class SpartanTestsWithPathParameters {

    @BeforeClass
    public void setupClass(){
        RestAssured.baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void pathTest1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .and().pathParam("id", 18)
                .when().get("/api/spartans/{id}");
        // verify status code
        assertEquals(response.statusCode(),200);
        // verify content type
        assertEquals(response.contentType(),"application/json");
        // verify Allen exists
        assertTrue(response.body().asString().contains("Allen"));

        response.body().prettyPrint();
    }

    @Test
    public void negativePathParamTest(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .pathParam("id", 500)
                .when().get("/api/spartans/{id}");
        // verify status code 404
        assertEquals(response.statusCode(),404);
        // verify content type
        assertEquals(response.contentType(),"application/json");
        // verify Spartan not found
        assertTrue(response.body().asString().contains("Not Found"));

        response.prettyPrint();

    }


}
