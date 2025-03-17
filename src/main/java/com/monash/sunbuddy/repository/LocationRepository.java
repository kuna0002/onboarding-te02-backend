package com.monash.sunbuddy.repository;

import com.monash.sunbuddy.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

/**
 * Repository interface for performing database operations on the {@link Location} entity.
 * <p>
 * This interface extends {@link JpaRepository}, providing built-in CRUD operations
 * as well as a custom query method for searching locations by name.
 * </p>
 *
 * <p>Spring Data JPA automatically implements this repository, eliminating the need
 * for manual DAO implementations.</p>
 */
public interface LocationRepository extends JpaRepository<Location, Long> {

    /**
     * Finds a list of locations where the name contains the given substring,
     * ignoring case sensitivity.
     *
     * @param substring The substring to search for within location names.
     * @return A list of {@link Location} objects matching the search criteria.
     *
     * <p>Example Usage:</p>
     * <pre>
     * List<Location> results = locationRepository.findByLocNameContainingIgnoreCase("York");
     * </pre>
     */
    @Query("SELECT l FROM Location l WHERE LOWER(l.locName) LIKE LOWER(CONCAT('%', :substring, '%'))")
    List<Location> findByLocNameContainingIgnoreCase(@Param("substring") String substring);
}
