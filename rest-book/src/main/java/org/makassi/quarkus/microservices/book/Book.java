package org.makassi.quarkus.microservices.book;

import java.time.Instant;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

@Schema(description = "This is a book entity")
public class Book {
    @JsonProperty("isbn_13")
    @Schema(required = true)
    public String isbn13;
    @Schema(required = true)
    public String title;
    public String author;
    public String genre;
    @JsonProperty("creation_date")
    @Schema(implementation = String.class, format = "date")
    public Instant creationDate;

    @Override
    public String toString() {
        return "Book [isbn13=" + isbn13 + ", title=" + title + ", author=" + author + ", genre=" + genre
                + ", yearOfPublication=" + creationDate + "]";
    }
}
