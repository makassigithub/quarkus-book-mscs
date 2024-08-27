package org.makassi.quarkus.microservices.isbn;

import org.eclipse.microprofile.openapi.annotations.ExternalDocumentation;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;

@ApplicationPath("/")
@OpenAPIDefinition(info = @Info(title = "Isbn microservice", version = "1.0", description = "Microservice that generates book ISBN number", contact = @Contact(name = "Brahima", url = "https://google.com")), externalDocs = @ExternalDocumentation(url = "https://google.com", description = "All the microservice code"), tags = {
        @Tag(name = "api", description = "API that is used for all the microservices"),
        @Tag(name = "isbns", description = "API for getting book isbns")
})
public class IsbnMicroservice extends Application {

}
