package com.monash.sunbuddy.model;

import jakarta.persistence.*;
import lombok.*;

/**
 * Entity class representing the location table in the database.
 * This class stores information about different locations including
 * their name, state, postal code, and geographical coordinates.
 *
 * Lombok annotations are used to reduce boilerplate code.
 * - {@code @Data} generates getters, setters, toString, equals, and hashCode.
 * - {@code @NoArgsConstructor} generates a no-arguments constructor.
 * - {@code @AllArgsConstructor} generates an all-arguments constructor.
 */
@Entity
@Table(name = "location")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Location {

    /**
     * The unique identifier for the location.
     * This is the primary key and is auto-generated.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loc_id")
    private Long locId;

    /**
     * The name of the location (e.g., city or suburb).
     */
    @Column(name = "loc_name", nullable = false)
    private String locName;

    /**
     * The postal code associated with the location.
     */
    @Column(name = "postcode", nullable = false)
    private String postcode;

    /**
     * The state or region where the location is situated.
     */
    @Column(name = "state", nullable = false)
    private String locstate;

    /**
     * The longitude coordinate of the location.
     */
    @Column(name = "lon", nullable = false)
    private Double longitude;

    /**
     * The latitude coordinate of the location.
     */
    @Column(name = "lat", nullable = false)
    private Double latitude;
}
