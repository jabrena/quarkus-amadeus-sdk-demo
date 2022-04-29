package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class CovidResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/api/v1/covid-restrictions")
          .then()
          .statusCode(200);
    }

}