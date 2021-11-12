package com.stepcio.webfluxfun.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WeatherData {
    float latitude;
    float longitude;
    String cityName;
    int pressure;
    float temperature;
    int cloudCoverage;
}
