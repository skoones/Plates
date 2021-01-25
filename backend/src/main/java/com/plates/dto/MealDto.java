package com.plates.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Set;

/**
 * Represents a data transfer object for Meal in order to permit communication with frontend.
 */
@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class MealDto {

    private Long id;

    @EqualsAndHashCode.Include
    private String name;

    private String description;

    private String recipeLink;

    private Set<String> mealType;

    private Set<String> dietType;

}
