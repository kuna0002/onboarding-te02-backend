package com.monash.sunbuddy.dto;

import lombok.Data;

@Data
public class WeatherResponseDTO {
    private double latitude;
    private double longitude;
    private double generationtime_ms;
    private int utc_offset_seconds;
    private String timezone;
    private String timezone_abbreviation;
    private double elevation;
    private WeatherUnits current_units;
    private CurrentWeather current;

    @Data
    public static class WeatherUnits {
        private String time;
        private String interval;
        private String temperature_2m;
        private String apparent_temperature;
        private String uv_index;
    }

    @Data
    public static class CurrentWeather {
        private String time;
        private int interval;
        private double temperature_2m;
        private double apparent_temperature;
        private double uv_index;
    }
}
