package com.upwork.sync.csv.services;

import io.micronaut.core.async.publisher.Publishers;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

import java.io.File;
import java.net.URI;

import static io.micronaut.http.HttpHeaders.ACCEPT;

@Singleton
public class CsvHttpClient {

    private final HttpClient httpClient;

    public CsvHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Publisher<?> fetchData(String url) {
        URI uri = buildUri(url);

        HttpRequest<?> req = HttpRequest.GET(uri)
                .header(ACCEPT, MediaType.TEXT_CSV);

//        return httpClient.retrieve(req); <- Need to be returned
        return new Publishers.JustPublisher<>(new File("catalog.csv"));
    }

    private URI buildUri(String url) {
        return UriBuilder
                .of(url)
                .build();
    }
}
