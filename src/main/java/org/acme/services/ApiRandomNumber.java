package org.acme.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.logging.Log;
import org.acme.dto.ApiResult;

import javax.enterprise.context.ApplicationScoped;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class ApiRandomNumber implements IRandomNumber {

    private final String apiKey = "1bf094ee-1e95-4c0a-9921-eb71726c0420";
    private final Integer n = 5;
    private final Integer min = 1;
    private final Integer max = 100;
    private final String uri = "https://api.random.org/json-rpc/4/invoke";
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    public ApiRandomNumber() {
    }

    public String callHttp(String request) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .header("Accept", "application/json")
                .header("Content-type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(request))
                .build();
        HttpResponse<String> httpResponse = HttpClient.newHttpClient().send(httpRequest,
                HttpResponse.BodyHandlers.ofString());
        Log.info("httpResponse :" + httpResponse);
        Log.info("body :" + httpResponse.body());

        return httpResponse.body();
    }

    public String createRequestBody() throws JsonProcessingException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("apiKey", "1bf094ee-1e95-4c0a-9921-eb71726c0420");
        params.put("n", n);
        params.put("min", min);
        params.put("max", max);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jsonrpc", "2.0");
        map.put("method", "generateIntegers");
        map.put("params", params);
        map.put("id", 42);
        ObjectMapper objectMapper = new ObjectMapper();

        String requestBody = objectMapper
                .writerWithDefaultPrettyPrinter()
                .writeValueAsString(map);

        return requestBody;

    }

    @Override
    public Integer[] getNumber() throws IOException, URISyntaxException, InterruptedException {
        String params = createRequestBody();
        String responseBody = callHttp(params);
        ObjectMapper objectMapper = new ObjectMapper();
        ApiResult apiResult = objectMapper.readValue(responseBody, ApiResult.class);

        return apiResult.getResult().getRandom().getData();

    }
}