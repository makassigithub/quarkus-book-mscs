package org.makassi.quarkus.microservices.book;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import io.quarkus.test.Mock;

@Mock
@RestClient
public class IsbnServiceProxyMock implements IsbnServiceProxy {

    @Override
    public Isbn13Number getIsbn13Number() {
        Isbn13Number isbn13 = new Isbn13Number();
        isbn13.isbn13 = "13-Mock";
        return isbn13;
    }

}
