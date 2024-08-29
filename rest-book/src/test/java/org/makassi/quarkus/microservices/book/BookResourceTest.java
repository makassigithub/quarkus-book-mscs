package org.makassi.quarkus.microservices.book;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.startsWith;

@QuarkusTest
class BookResourceTest {
    @Test
    void shouldCreateABook() {
        given()
                .formParam("title", "Begining javaEE")
                .formParam("author", "Antonio G")
                .formParam("genre", "Programming")
                .formParam("year", 2024)
                .when()
                .post("/api/books")
                .then()
                .statusCode(201)
                .body("title", startsWith("Begining"))
                .body("isbn_13", startsWith("13-"))
                .body("creation_date", startsWith("20"));
    }

}