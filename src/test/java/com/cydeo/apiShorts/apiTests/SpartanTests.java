package com.cydeo.apiShorts.apiTests;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SpartanTests {

    String spartanBaseUrl = "http://100.26.201.240:8000";

    @Test
    public void viewSpartanTest1(){

        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");
        // print status code
        System.out.println(response.statusCode());
        //print body
        System.out.println(response.body().prettyPrint());

    }

    @Test
    public void viewSpartanTest2(){
        Response response = RestAssured.get(spartanBaseUrl + "/api/spartans");
        // status code must be 200
        Assert.assertEquals(response.statusCode(),200);
        // verify body contains Allen
        Assert.assertTrue(response.body().asString().contains("Allen"));
    }

    @Test
    public void viewSpartanTest3(){

        Response response = RestAssured.given().accept(ContentType.JSON)
                .when().get(spartanBaseUrl+"/api/spartans");
        // verify status code 200
        Assert.assertEquals(response.statusCode(),200);
        // verify response body json
        Assert.assertEquals(response.contentType(),"application/json");
    }

}
