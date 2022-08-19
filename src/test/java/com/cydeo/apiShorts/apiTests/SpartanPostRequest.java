package com.cydeo.apiShorts.apiTests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;
public class SpartanPostRequest {

    @BeforeClass
    public void setup(){
        baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void postWithString(){
        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body("{\n" +
                        "        \"id\": 110,\n" +
                        "        \"name\": \"Mike\",\n" +
                        "        \"gender\": \"Male\",\n" +
                        "        \"phone\": 2025478854\n" +
                        "    }")
                .when().post("/api/spartans/");
        response.prettyPrint();

        // validations
        // verify status code is 201
        assertEquals(response.statusCode(),201);
        assertEquals(response.contentType(),"application/json");

        // verify success message
        assertEquals(response.path("success"),"A Spartan is Born!");

        // verify request body
        JsonPath json = response.jsonPath();

        assertEquals(json.getString("data.name"),"Mike");
        assertEquals(json.getString("data.gender"),"Male");
        assertEquals(json.getLong("data.phone"),2025478854);

    }

    @Test
    public void postMethodWithMap(){

        // create a map to be used as a body for post request
        Map<String,Object> requestMap = new HashMap<>();
        requestMap.put("name","MikeMap");
        requestMap.put("gender","Male");
        requestMap.put("phone",2025478854);

        Response response = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .body(requestMap)
                .when().post("/api/spartans/");

        assertEquals(response.statusCode(),201);
        response.prettyPrint();

    }

}
