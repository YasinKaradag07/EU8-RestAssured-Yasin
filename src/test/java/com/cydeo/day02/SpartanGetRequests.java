package com.cydeo.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SpartanGetRequests {

    String baseUrl = "http://100.26.201.240:8000";

    /*
    Given Accept type application/json
    When user send GET request to api/spartans end point
    Then status code must be 200
    And response content type must be application/json
    And response body should include Spartan result
     */

    @Test
    public void test1(){
        Response response = RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl+"/api/spartans");
        //printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        //printing response content type from response object
        System.out.println("response.contentType() = " + response.contentType());

        // pri,nt whole result body
        response.prettyPrint();

        // how to do API testing then?
        // verify status code is 200
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type is application/json
        Assertions.assertEquals(response.contentType(),"application/json");

    }

    /*
        Given accept header is application/json
        When users send a get request to /api/spartans/3
        Then status code should be 200
        And content type should be application/json
        and json body should contain Fidole
     */

    @DisplayName("Get one spartan /api/spartans/3 and verify")
    @Test
    public void test2(){
        Response response = RestAssured.given().accept(ContentType.JSON).
                when().get(baseUrl+"/api/spartans/3");

        // verify status code 200
        Assertions.assertEquals(response.statusCode(),200);

        // verify content type
        Assertions.assertEquals(response.contentType(),"application/json");

        // verify json body contains Fidole
        Assertions.assertTrue(response.body().asString().contains("Fidole"));
    }




}