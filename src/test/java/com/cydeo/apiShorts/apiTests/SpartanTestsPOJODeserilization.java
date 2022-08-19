package com.cydeo.apiShorts.apiTests;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class SpartanTestsPOJODeserilization {

    @BeforeClass
    public void setup(){
        baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 15)
                .when().get("/api/spartans/{id}");

        // GSON library===> de-serialization
        // how to convert json response to our spartan class
        Spartan spartan1 = response.body().as(Spartan.class);

        // verify each key with Spartan object
        assertEquals(spartan1.getName(),"Meta");
        assertEquals(spartan1.getId(),15);
        assertEquals(spartan1.getGender(),"Female");
        assertEquals(spartan1.getPhone(), Long.valueOf(1938695106));


    }

    @Test
    public void gsonExample(){

        Gson gson = new Gson();

        String myJsonBody = "{\n" +
                "    \"id\": 15,\n" +
                "    \"name\": \"Meta\",\n" +
                "    \"gender\": \"Female\",\n" +
                "    \"phone\": 1938695106\n" +
                "}";

        // Using gson method do de-serialize our json body
        Spartan spartanMeta = gson.fromJson(myJsonBody,Spartan.class);

        System.out.println(spartanMeta.toString());

        // serialization Java object ===> JSON body

        Spartan spartan = new Spartan(101,"Mike","Male",321342123l);

        // converting custom class to json
        String jsonbody = gson.toJson(spartan);

        System.out.println(jsonbody);

    }


}
