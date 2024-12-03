package org.cherry.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ProductAPITest {
    private static final String phone = "1234567890";
    private static final String password = "qwertyy";
    private String authToken;

    @Before
    public void setup() {
        // Base configuration
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testLoginAndProductRetrieval() {
        // Login and get token
        Response loginResponse = RestAssured.given()
                .contentType("application/json")
                .body(getLoginBody().toJSONString())
                .when()
                .post("/user/login");

        // Validate login
        Assert.assertEquals(200, loginResponse.getStatusCode());

        // Extract auth token
        // Fetch products with auth token
        Response productResponse = RestAssured.given()
                .contentType("application/json")
                .when()
                .get("/products/all");

        // Validate product retrieval
        Assert.assertEquals(200, productResponse.getStatusCode());
        Assert.assertNotNull(productResponse.getBody());
        System.out.println("Products: " + productResponse.getBody().asString());
        System.out.println("Status Code: " + productResponse.getStatusCode());
    }

    private static JSONObject getLoginBody() {
        JSONObject body = new JSONObject();
        body.put("phoneNumber", phone);
        body.put("password", password);
        return body;
    }
}