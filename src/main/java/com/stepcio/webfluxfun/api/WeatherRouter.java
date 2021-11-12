package com.stepcio.webfluxfun.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class WeatherRouter {

    @Bean
    RouterFunction<ServerResponse> routes(WeatherHandler weatherHandler) {
        return RouterFunctions.route()
                .GET("/getWeather", RequestPredicates.accept(MediaType.APPLICATION_JSON), weatherHandler::weatherHandler)
                .build();
    }

}
