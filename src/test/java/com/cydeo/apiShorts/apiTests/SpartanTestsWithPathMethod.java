package com.cydeo.apiShorts.apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class SpartanTestsWithPathMethod {


    @BeforeClass
    public void setupClass(){
        RestAssured.baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void test1(){
        Response response = given().accept(ContentType.JSON)
                .pathParam("id",10)
                        .when().get("/api/spartans/{id}");

        // verify status code
        assertEquals(response.statusCode(),200);

        // verify content
        assertEquals(response.contentType(),"application/json");

        System.out.println("Id: "+response.path("id").toString());
        System.out.println("name :"+response.path("name").toString());
        System.out.println("gender :"+response.path("gender").toString());
        System.out.println("phone :"+response.path("phone").toString());

        int id = response.path("id");
        String name = response.body().path("name");
        String gender = response.body().path("gender");
        long phone = response.path("phone");

        System.out.println("id = " + id);
        System.out.println("name = " + name);
        System.out.println("gender = " + gender);
        System.out.println(phone);

        assertEquals(id,10);
        assertEquals(name,"Lorenza");
        assertEquals(gender,"Female");
        assertEquals(phone,3312820936l);

    }

    @Test
    public void test2(){

        Response response = get("/api/spartans");

        // extract first id
        int firstId = response.path("id[0]");
        System.out.println("firstId = " + firstId);

        // extract first name
        String firstName = response.path("name[1]");
        System.out.println("firstName = " + firstName);

        // get the last firstname
        String lastFirstName = response.path("name[-1]");
        System.out.println("lastFirstName = " + lastFirstName);

        // extract all firstnames and print them
        List<String> names = response.path("name");
        System.out.println(names);
        System.out.println("names.size() = " + names.size());

        List<Object> phoneNumbers = response.path("phone");

        for (Object phoneNumber : phoneNumbers) {
            System.out.println(phoneNumber);
        }
    }


}
