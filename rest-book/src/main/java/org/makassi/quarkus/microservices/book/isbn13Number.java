package org.makassi.quarkus.microservices.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Isbn13Number {
    @JsonProperty("isbn_13")
    public String isbn13;
}
