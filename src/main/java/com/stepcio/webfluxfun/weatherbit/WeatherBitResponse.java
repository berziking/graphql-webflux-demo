package com.stepcio.webfluxfun.weatherbit;

import com.stepcio.webfluxfun.dto.WeatherDto;
import lombok.Data;
import java.util.List;
import java.util.stream.Collectors;

@Data
class WeatherBitResponse {
    private int count;
    private List<WeatherBitData> data;

    public WeatherDto toWeatherDto() {
        return new WeatherDto(count, data.stream()
                .map(WeatherBitData::toLocationWeatherDto)
                .collect(Collectors.toList()));
    }
}
