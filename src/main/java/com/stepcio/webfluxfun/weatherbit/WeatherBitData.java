package com.stepcio.webfluxfun.weatherbit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.stepcio.webfluxfun.dto.WeatherData;
import lombok.Data;

@Data
class WeatherBitData {
    @JsonProperty("lat")
    float latitude;
    @JsonProperty("lon")
    float longitude;
    @JsonProperty("city_name")
    String cityName;
    @JsonProperty("pres")
    int pressure;
    @JsonProperty("temp")
    float temperature;
    @JsonProperty("clouds")
    int cloudCoverage;

    public WeatherData toLocationWeatherDto() {
        return WeatherData.builder()
                .latitude(latitude)
                .longitude(longitude)
                .cityName(cityName)
                .pressure(pressure)
                .temperature(temperature)
                .cloudCoverage(cloudCoverage)
                .build();
    }
}
