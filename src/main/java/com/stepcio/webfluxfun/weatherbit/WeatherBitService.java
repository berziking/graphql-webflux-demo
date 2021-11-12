package com.stepcio.webfluxfun.weatherbit;

import com.stepcio.webfluxfun.dto.WeatherDto;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class WeatherBitService {
    WeatherBitClient weatherBitClient;

    public Mono<WeatherDto> getWeather(String city) {
        return weatherBitClient.getWeather(city)
                .map(WeatherBitResponse::toWeatherDto);
    }
}
