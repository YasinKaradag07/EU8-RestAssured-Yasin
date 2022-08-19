package com.cydeo.apiShorts.apiTests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import static org.testng.Assert.*;

public class SpartanJsonToCollections {

    @BeforeClass
    public void setupClass(){
        RestAssured.baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void test1(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("id", 11)
                .and().when().get("/api/spartans/{id}");

        // convert json to java collections(Map)
        Map <String,Object> spartanMap = response.body().as(Map.class);

        System.out.println(spartanMap.get("name"));
        System.out.println(spartanMap.get("id"));

        assertEquals(spartanMap.get("name"),"Nona");
    }

    @Test
    public void test2(){

        Response response = given().accept(ContentType.JSON)
                .when().get("/api/spartans");

        //response.prettyPrint();
        // convert full json body to list of maps
        List<Map<String,Object>> listOfSpartans = response.body().as(List.class);

        // print all data of first spartan
        System.out.println(listOfSpartans.get(0));
        Map<String,Object> firstSpartan = listOfSpartans.get(0);
        System.out.println(firstSpartan.get("name"));

        int counter = 1;
        for (Map<String, Object> map : listOfSpartans) {
            System.out.println(counter+". - spartan "+map);
            counter++;
        }

    }

}
