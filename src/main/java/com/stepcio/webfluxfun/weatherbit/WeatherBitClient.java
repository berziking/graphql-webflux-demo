package com.stepcio.webfluxfun.weatherbit;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
class WeatherBitClient {
    public static final String URI = "https://api.weatherbit.io/v2.0?key=2580b24862e04def91763d9aaf346121&include=minutely&city={city}";
    WebClient webClient;

    public WeatherBitClient() {
        this.webClient = WebClient.create(URI);
    }

    public Mono<WeatherBitResponse> getWeather(String city) {
        return webClient.get()
                .uri("/current", city)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(WeatherBitResponse.class);
    }
}
