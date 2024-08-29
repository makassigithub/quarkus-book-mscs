package org.makassi.quarkus.microservices.isbn;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.hasKey;;

@QuarkusTest
class IsbnResourceTest {
    @Test
    void testHelloEndpoint() {
        given()
                .when().get("/api/isbns")
                .then()
                .statusCode(200)
                .body("isbn_13", startsWith("13-"))
                .body("isbn_10", startsWith("10-"))
                .body(not(hasKey("generationDate")));
    }

}