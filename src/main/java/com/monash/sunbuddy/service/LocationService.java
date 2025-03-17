package com.monash.sunbuddy.service;

import com.monash.sunbuddy.model.Location;
import com.monash.sunbuddy.repository.LocationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * Service class for handling business logic related to locations.
 * <p>
 * This class interacts with the {@link LocationRepository} to retrieve
 * location data based on a substring search.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class LocationService {

    /**
     * Repository for performing database operations related to {@link Location}.
     */
    private final LocationRepository locationRepository;

    /**
     * Retrieves a list of locations where the name contains the specified substring,
     * ignoring case sensitivity.
     *
     * @param substring The substring to search for in location names.
     * @return A list of {@link Location} objects that match the search criteria.
     *
     * <p>Example Usage:</p>
     * <pre>
     * List<Location> results = locationService.getLocationsBySubstring("York");
     * </pre>
     *
     * <p>This method calls the repository method {@link LocationRepository#findByLocNameContainingIgnoreCase(String)}
     * which executes a case-insensitive SQL query.</p>
     */
    public List<Location> getLocationsBySubstring(String substring) {
        return locationRepository.findByLocNameContainingIgnoreCase(substring);
    }
}
