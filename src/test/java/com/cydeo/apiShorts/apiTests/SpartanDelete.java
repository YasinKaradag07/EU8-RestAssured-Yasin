package com.cydeo.apiShorts.apiTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.*;

public class SpartanDelete {

    @BeforeClass
    public void setup(){
        baseURI="http://100.26.201.240:8000";
    }

    @Test
    public void test1(){

        given().pathParam("id",103)
                .when().delete("/api/spartans/{id}")
                .then().assertThat().statusCode(204);

        // verify part
        given().pathParam("id",103)
                .when().delete("/api/spartans/{id}")
                .then().assertThat().statusCode(404);
    }

}
