package com.cydeo.apiShorts.apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class SpartanTestsWithJsonPath {

    @BeforeClass
    public void setupClass(){
        RestAssured.baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(),200);
        // how to read value with path() method
        int id = response.path("id");
        System.out.println("id = " + id);

        // how to read value with json path
        JsonPath jsonData = response.jsonPath();

        int id1 = jsonData.getInt("id");
        String name = jsonData.getString("name");
        String gender = jsonData.getString("gender");
        long phone = jsonData.getLong("phone");

        System.out.println("id1 = " + id1);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println("phone = " + phone);

        // verify json payload with JsonPath
        assertEquals(id1,11);
        assertEquals(name,"Nona");
        assertEquals(gender,"Female");
        assertEquals(phone,7959094216l);
    }

}
