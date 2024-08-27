package org.makassi.quarkus.microservices.isbn;

import java.time.Instant;
import java.util.Random;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/isbns")
@Tag(name = "isbn rest Endpoint")
public class IsbnResource {

    @Inject
    Logger logger;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Generate isbn numbers for a book", description = "send isbn10 and isbn13 to client")
    public IsbnNumbers generateIsbnNumbers() {
        IsbnNumbers isbn = new IsbnNumbers();
        isbn.isbn13 = "13-" + new Random().nextInt(100_000_000);
        isbn.isbn10 = "10-" + new Random().nextInt(100_000);
        logger.info("Generated isbnNumber" + isbn);
        isbn.generationDate = Instant.now();
        return isbn;
    }
}
