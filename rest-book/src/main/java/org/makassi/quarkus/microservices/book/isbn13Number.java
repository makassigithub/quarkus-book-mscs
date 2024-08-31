package org.makassi.quarkus.microservices.book;

import com.fasterxml.jackson.annotation.JsonProperty;

public class isbn13Number {

    @JsonProperty("isbn_13")
    public String isbn13;
}
