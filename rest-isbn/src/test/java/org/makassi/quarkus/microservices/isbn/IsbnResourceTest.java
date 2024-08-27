package org.makassi.quarkus.microservices.isbn;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class IsbnResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/isbns")
          .then()
             .statusCode(200)
             .body(is("Hello RESTEasy"));
    }

}