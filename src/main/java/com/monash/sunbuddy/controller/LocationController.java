package com.monash.sunbuddy.controller;

import com.monash.sunbuddy.model.Location;
import com.monash.sunbuddy.service.LocationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * REST Controller for managing location-related operations.
 * <p>
 * This controller provides an endpoint to search for locations
 * based on a substring match of their names.
 * </p>
 *
 * <p>Base API Path: <b>/api/locations</b></p>
 *
 * Lombok's {@code @RequiredArgsConstructor} is used to inject
 * {@link LocationService} as a final field.
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/locations")
@RequiredArgsConstructor
public class LocationController {

    /**
     * Service layer to handle business logic related to locations.
     */
    private final LocationService locationService;

    /**
     * Searches for locations that match the given query string.
     *
     * @param query The substring to search for in location names.
     * @return A list of {@link Location} objects matching the query.
     *
     * <p>Example API Request:</p>
     * <pre>
     * GET /api/locations/search?query=York
     * </pre>
     * <p>Example JSON Response:</p>
     * <pre>
     * [
     *     { "locId": 1, "locName": "New York", "postcode": "10001", "state": "NY", "longitude": -74.006, "latitude": 40.7128 },
     *     { "locId": 2, "locName": "Yorktown", "postcode": "23690", "state": "VA", "longitude": -76.508, "latitude": 37.2388 }
     * ]
     * </pre>
     */
    @GetMapping("/search")
    public List<Location> searchLocations(@RequestParam String query) {
        return locationService.getLocationsBySubstring(query);
    }
}
