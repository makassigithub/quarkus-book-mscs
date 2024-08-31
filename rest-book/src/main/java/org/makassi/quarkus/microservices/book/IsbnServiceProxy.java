package org.makassi.quarkus.microservices.book;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/isbns")
@RegisterRestClient(configKey = "isbns.proxy")
public interface IsbnServiceProxy {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    Isbn13Number getIsbn13Number();
}
