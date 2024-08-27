#!/usr/bin/env bash
mvn -U io.quarkus:quarkus-maven-plugin:create \
        -DprojectGroupId=org.makassi.quarkus.microservices \
        -DprojectArtifactId=rest-isbn \
        -DclassName="org.makassi.quarkus.microservices.isbn.IsbnResource" \
        -Dpath="/api/isbns" \
        -Dextensions="resteasy-jsonb, smallrye-openapi"