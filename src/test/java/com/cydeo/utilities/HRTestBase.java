package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class HRTestBase {

    @BeforeAll
    public static void init(){
        // save baseUrl inside this variable so that we don't need to type each http method.
        baseURI = "http://100.26.201.240:1000/ords/hr";
    }
}
