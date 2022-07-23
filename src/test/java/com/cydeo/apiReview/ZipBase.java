package com.cydeo.apiReview;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class ZipBase {

    @BeforeAll
    public static void init(){
        baseURI = "http://api.zippopotam.us";
        basePath = "/us";
    }
}
