package com.cydeo.apiShorts.apiTests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SpartanTestWithHamcrest {

    @BeforeClass
    public void setupClass(){
        RestAssured.baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void test1(){

        given().accept(ContentType.JSON)
                .pathParam("id",15)
                .when().get("/api/spartans/{15}")
                .then().statusCode(200).and()
                .assertThat().contentType("application/json");

    }

    @Test
    public void test2(){
        given().accept(ContentType.JSON)
                .pathParam("id",15)
                .when().get("/api/spartans/{id}")
                .then().assertThat().statusCode(200)
                .and().assertThat().contentType("application/json")
                .and().assertThat().body("id", equalTo(15),
                        "name",equalTo("Meta"),
                        "gender",equalTo("Female"),"phone",equalTo(1938695106));
    }


}
