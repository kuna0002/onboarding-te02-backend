package com.monash.sunbuddy.service;

import com.monash.sunbuddy.dto.WeatherResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Service class responsible for fetching weather details from an external weather API.
 * <p>
 * This class interacts with the Open-Meteo API to retrieve weather data
 * based on latitude and longitude.
 * </p>
 *
 * <p>Spring's {@code @Service} annotation marks this class as a service component.</p>
 * <p>Lombok's {@code @RequiredArgsConstructor} generates a constructor for required fields.</p>
 */
@Service
@RequiredArgsConstructor
public class WeatherService {

    /**
     * WebClient instance used for making non-blocking HTTP requests.
     */
    private final WebClient webClient = WebClient.create();

    /**
     * Base URL of the Open-Meteo API, injected from application properties.
     */
    @Value("${open-meteo.api.url}")
    private String apiUrl;

    /**
     * Fetches weather data including temperature and UV index based on the given latitude and longitude.
     *
     * @param latitude  The latitude coordinate of the location.
     * @param longitude The longitude coordinate of the location.
     * @return A {@link Mono} emitting {@link WeatherResponseDTO} containing temperature, apparent temperature, and UV index.
     *
     * <p>Example API Request:</p>
     * <pre>
     * GET /api/weather?latitude=29.625&longitude=77.0
     * </pre>
     *
     * <p>Example External API Call:</p>
     * <pre>
     * https://api.open-meteo.com/v1/forecast?latitude=29.625&longitude=77.0&current=temperature_2m,apparent_temperature,uv_index
     * </pre>
     */
    public Mono<WeatherResponseDTO> getWeatherByLatLong(double latitude, double longitude) {
        String url = String.format("%s?latitude=%s&longitude=%s&current=temperature_2m,apparent_temperature,uv_index",
                apiUrl, latitude, longitude);

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(WeatherResponseDTO.class);
    }
}
