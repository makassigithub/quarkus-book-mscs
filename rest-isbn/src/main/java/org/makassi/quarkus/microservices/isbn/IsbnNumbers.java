package org.makassi.quarkus.microservices.isbn;

import java.time.Instant;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Schema(description = "Several isbns for books")
public class IsbnNumbers {
    @JsonProperty("isbn_10")
    @Schema(required = true)
    public String isbn10;

    @Schema(required = true)
    @JsonProperty("isbn_13")
    public String isbn13;

    @JsonIgnore
    public Instant generationDate;

    @Override
    public String toString() {
        return "IsbnNumbers [isbn10=" + isbn10 + ", isbn13=" + isbn13 + ", generationDate=" + generationDate + "]";
    }
}
