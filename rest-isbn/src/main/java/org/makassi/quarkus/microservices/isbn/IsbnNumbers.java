package org.makassi.quarkus.microservices.isbn;

import java.time.Instant;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;

@Schema(description = "Several isbns for books")
public class IsbnNumbers {
    @JsonbProperty("isbn_10")
    @Schema(required = true)
    public String isbn10;

    @Schema(required = true)
    @JsonbProperty("isbn_13")
    public String isbn13;

    @JsonbTransient
    public Instant generationDate;

    @Override
    public String toString() {
        return "IsbnNumbers [isbn10=" + isbn10 + ", isbn13=" + isbn13 + ", generationDate=" + generationDate + "]";
    }
}
