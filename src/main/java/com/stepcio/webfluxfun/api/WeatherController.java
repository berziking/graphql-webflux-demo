package com.stepcio.webfluxfun.api;

import com.stepcio.webfluxfun.dto.WeatherDto;
import com.stepcio.webfluxfun.weatherbit.WeatherBitService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class WeatherController {
    private final WeatherBitService weatherBitService;

    @QueryMapping
    public Mono<WeatherDto> weather(@Argument String city) {
        return weatherBitService.getWeather(city);
    }
}