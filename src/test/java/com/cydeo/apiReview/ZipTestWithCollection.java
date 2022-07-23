package com.cydeo.apiReview;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class ZipTestWithCollection extends ZipBase{

    @Test
    public void collectionTest(){

        Response response = given().accept(ContentType.JSON)
                .pathParam("zip",22031)
                .when()
                .get("/{zip}");
        response.prettyPrint();

        Map<String,Object> postCode = response.body().as(Map.class);
        System.out.println("postCode.get(\"post code\") = "+postCode.get("post code"));

        assertEquals("United States",postCode.get("country"));

        // "state" : "Virginia" verify: this information is inside the "places" key
        List<Map<String,Object>> places = (List<Map<String, Object>>) postCode.get("places");

        assertEquals("Virginia",places.get(0).get("state"));
        assertEquals("Fairfax",places.get(0).get("place name"));

    }

}
