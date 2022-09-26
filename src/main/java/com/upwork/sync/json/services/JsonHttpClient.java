package com.upwork.sync.json.services;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.MediaType;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.uri.UriBuilder;
import jakarta.inject.Singleton;
import org.reactivestreams.Publisher;

import java.net.URI;

import static io.micronaut.http.HttpHeaders.ACCEPT;

@Singleton
public class JsonHttpClient {

    private final HttpClient httpClient;

    public JsonHttpClient(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    public Publisher<?> fetchData(String url) {
        URI uri = buildUri(url);

        HttpRequest<?> req = HttpRequest.GET(uri)
                .header(ACCEPT, MediaType.APPLICATION_JSON)
                .header("X-CSRF-TOKEN", "lu1iC4GpGk1vVJoR4FHowXtjLgMRxpQLHzhdCnBZ");

        return httpClient.retrieve(req);
    }

    private URI buildUri(String url) {
        return UriBuilder
                .of(url)
                .build();
    }
}
