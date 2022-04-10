package pl.sda.database;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class MainApp {

    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/get"))
                .build();

        HttpRequest request2 = HttpRequest.newBuilder()
                .uri(new URI("https://openweathermap.org/api"))
                .build();

        HttpRequest request3 = HttpRequest.newBuilder()
                .uri(new URI("https://developer.accuweather.com/apis"))
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request2, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());

    }
}
