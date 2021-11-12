package com.stepcio.webfluxfun.api;

import com.stepcio.webfluxfun.dto.WeatherDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import com.stepcio.webfluxfun.weatherbit.WeatherBitService;

@Component
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class WeatherHandler {
    WeatherBitService weatherBitService;

    public Mono<ServerResponse> weatherHandler(ServerRequest serverRequest) {
        var city = serverRequest.queryParam("city").orElseThrow();
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(weatherBitService.getWeather(city), WeatherDto.class);
    }
}
