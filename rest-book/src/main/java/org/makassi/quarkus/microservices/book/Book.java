package org.makassi.quarkus.microservices.book;

import java.time.Instant;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;

@Schema(description = "This is a book entity")
public class Book {
    @JsonbProperty("isbn_13")
    @Schema(required = true)
    public String isbn13;
    @Schema(required = true)
    public String title;
    public String author;
    public String genre;
    @JsonbDateFormat("yyyy/MM/dd")
    @JsonbProperty("creation_date")
    @Schema(implementation = String.class, format = "date")
    public Instant creationDate;

    @Override
    public String toString() {
        return "Book [isbn13=" + isbn13 + ", title=" + title + ", author=" + author + ", genre=" + genre
                + ", yearOfPublication=" + creationDate + "]";
    }
}
