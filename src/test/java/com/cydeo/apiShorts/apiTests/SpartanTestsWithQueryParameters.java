package com.cydeo.apiShorts.apiTests;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static org.testng.Assert.*;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class SpartanTestsWithQueryParameters {

    @BeforeClass
    public void setupClass(){
        RestAssured.baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void queryParam1(){
        Response response = given().accept(ContentType.JSON)
                .and().queryParam("gender","Female")
                .and().queryParam("nameContains","J")
                .when().get("/api/spartans/search");

        // verify response code
        assertEquals(response.statusCode(),200);
        //verify content type
        assertEquals(response.contentType(),"application/json");
        // verify Female
        assertTrue(response.body().asString().contains("Janette"));
        // verify male not exists
        assertFalse(response.body().asString().contains("Male"));
        // verify Janette
        assertTrue(response.body().asString().contains("Janette"));
    }

    @Test
    public void queryParams2(){

        // creating map for query params
        Map<String,Object> paramsMap = new HashMap<>();
        paramsMap.put("gender","Female");
        paramsMap.put("nameContains","J");

        // send request
        Response response = given().accept(ContentType.JSON)
                .and().queryParams(paramsMap)
                .when().get("/api/spartans/search");

        // verify status code
        assertEquals(response.statusCode(),200);
        //verify content type
        assertEquals(response.contentType(),"application/json");
        // verify Female
        assertTrue(response.body().asString().contains("Janette"));
        // verify male not exists
        assertFalse(response.body().asString().contains("Male"));
        // verify Janette
        assertTrue(response.body().asString().contains("Janette"));

    }



}
