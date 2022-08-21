package com.cydeo.apiShorts.apiTests;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
public class JsonSchemaValidation {

    @BeforeClass
    public void setup(){
        baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void test1(){

        given().accept(ContentType.JSON)
                .pathParam("id",10)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().body(matchesJsonSchemaInClasspath("SingleSpartanSchema.json"));



    }

}
