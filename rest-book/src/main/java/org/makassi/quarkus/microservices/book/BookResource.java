package org.makassi.quarkus.microservices.book;

import java.time.Instant;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.jboss.logging.Logger;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/api/books")
@Tag(name = "Book rest endpoint")
public class BookResource {

    @Inject()
    Logger logger;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(summary = "Create a book", description = "Book creation with isbn number")
    public Response createBook(
            @FormParam("title") String title,
            @FormParam("author") String author,
            @FormParam("genre") String genre,
            @FormParam("year") int creationDate) {
        Book book = new Book();
        book.title = title;
        book.author = author;
        book.genre = genre;
        book.isbn13 = "We will get it from isbn microservice";
        book.creationDate = Instant.now();

        logger.info(book);

        return Response.status(201).entity(book).build();
    }
}
