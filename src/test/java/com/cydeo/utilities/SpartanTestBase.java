package com.cydeo.utilities;

import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.baseURI;

public abstract class SpartanTestBase {

    @BeforeAll
    public static void init(){
        // save baseUrl inside this variable so that we don't need to type each http method.
        baseURI = "http://100.26.201.240:8000";

        String dbUrl = "jdbc:oracle:thin:@44.202.119.26:1521:xe";
        String dbUsername = "SP";
        String dbPassword = "SP";

        //DBUtils.createConnection(dbUrl,dbUsername,dbPassword);
    }
}
