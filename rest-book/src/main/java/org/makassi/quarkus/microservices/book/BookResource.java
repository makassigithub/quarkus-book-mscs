package org.makassi.quarkus.microservices.book;

import java.time.Instant;

import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.PrintWriter;
import java.io.IOException;
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

    @Inject()
    @RestClient
    IsbnServiceProxy proxy;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Operation(summary = "Create a book", description = "Book creation with isbn number")
    @Fallback(fallbackMethod = "fallBackOnCreatingAbook")
    @Retry(maxRetries = 3, delay = 3000)
    public Response createBook(
            @FormParam("title") String title,
            @FormParam("author") String author,
            @FormParam("genre") String genre,
            @FormParam("year") int creationDate) {
        Book book = new Book();
        book.title = title;
        book.author = author;
        book.genre = genre;
        book.isbn13 = proxy.getIsbn13Number().isbn13;
        book.creationDate = Instant.now();
        logger.info(book);
        return Response.status(201).entity(book).build();
    }

    public Response fallBackOnCreatingAbook(
            String title,
            String author,
            String genre,
            int creationDate) {
        Book book = new Book();
        book.title = title;
        book.author = author;
        book.genre = genre;
        book.isbn13 = "13-We will be created later";
        book.creationDate = Instant.now();
        logger.warn("The isbn service failed to reply and we are saving partial book to disk.");
        saveBookOnDisk(book);

        return Response.status(201).entity(book).build();
    }

    private void saveBookOnDisk(Book book) {
        ObjectMapper mapper = new ObjectMapper();
        // Register the JavaTimeModule
        mapper.registerModule(new JavaTimeModule());

        String fileName = "book-" + Instant.now().toEpochMilli() + ".json";

        try (PrintWriter writer = new PrintWriter(fileName)) {
            String bookString = mapper.writeValueAsString(book);
            writer.println(bookString);
        } catch (IOException exc) {
            logger.warn("Failed to save book to disk: {}", exc.getMessage(), exc);
        }
    }
}
