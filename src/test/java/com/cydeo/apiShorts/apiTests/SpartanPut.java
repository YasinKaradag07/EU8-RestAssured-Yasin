package com.cydeo.apiShorts.apiTests;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class SpartanPut {

    @BeforeClass
    public void setup(){
        baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void putRequest(){
        // different ways to send json body
        //-String
        //-Collection(Map)
        //-POJO

        // Using Map
        Map<String,Object> putMap = new HashMap<>();
        putMap.put("name","MikePut");
        putMap.put("gender","Male");
        putMap.put("phone",8877423456l);
        // we gonna send request body with updated value, and content type header
        given().contentType(ContentType.JSON)
                .and().pathParam("id",101)
                .and().body(putMap)
                .when().put("/api/spartans/{id}")
                .then().assertThat().statusCode(204);

    }

    @Test
    public void patchRequest(){
        // different ways to send json body
        //-String
        //-Collection(Map)
        //-POJO

        // Using Map
        Map<String,Object> patchMap = new HashMap<>();
        patchMap.put("name","JackPatch");

        // we gonna send request body with updated value, and content type header
        given().contentType(ContentType.JSON)
                .and().pathParam("id",101)
                .and().body(patchMap)
                .when().patch("/api/spartans/{id}")
                .then().assertThat().statusCode(204);

    }



}
