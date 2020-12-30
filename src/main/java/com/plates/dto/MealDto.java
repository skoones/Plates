package com.plates.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
public class MealDto {

    private Long id;

    @EqualsAndHashCode.Include
    private String name;

    private String description;

    @EqualsAndHashCode.Include
    private String recipeLink;

    private List<String> mealType;

    private List<String> dietType;

}
