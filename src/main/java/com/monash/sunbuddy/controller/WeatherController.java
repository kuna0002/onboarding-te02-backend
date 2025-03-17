package com.monash.sunbuddy.controller;

import com.monash.sunbuddy.dto.WeatherResponseDTO;
import com.monash.sunbuddy.service.WeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * REST Controller for fetching weather details based on latitude and longitude.
 * <p>
 * This controller interacts with an external weather API to retrieve
 * real-time weather data, including temperature and UV index.
 * </p>
 *
 * <p>Base API Path: <b>/api/weather</b></p>
 *
 * Lombok's {@code @RequiredArgsConstructor} is used to inject
 * {@link WeatherService} as a final field.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/weather")
@RequiredArgsConstructor
public class WeatherController {

    /**
     * Service layer responsible for making API calls to fetch weather details.
     */
    private final WeatherService weatherService;

    /**
     * Fetches weather data based on latitude and longitude.
     *
     * @param latitude  The latitude coordinate of the location.
     * @param longitude The longitude coordinate of the location.
     * @return A {@link Mono} emitting {@link WeatherResponseDTO} containing temperature and UV index.
     *
     * <p>Example API Request:</p>
     * <pre>
     * GET /api/weather?latitude=29.625&longitude=77.0
     * </pre>

     */
    @GetMapping
    public Mono<WeatherResponseDTO> getWeather(@RequestParam double latitude, @RequestParam double longitude) {
        return weatherService.getWeatherByLatLong(latitude, longitude);
    }
}
