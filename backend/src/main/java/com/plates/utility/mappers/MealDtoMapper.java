package com.plates.utility.mappers;

import com.plates.dto.MealDto;
import com.plates.model.DietType;
import com.plates.model.Meal;
import com.plates.model.MealType;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Enables conversion between Meal and its data transfer object representation.
 */
@UtilityClass
public class MealDtoMapper {

    /**
     * Converts Meal object to its data transfer object representation.
     *
     * @param meal The Meal object to be converted.
     * @return Data transfer object representation of the Meal object.
     */
    public MealDto mapToDto(Meal meal) {
        return MealDto.builder()
                .id(meal.getId())
                .name(meal.getName())
                .description(meal.getDescription())
                .recipeLink(meal.getRecipeLink())
                .dietType(convertToStringSet(meal.getDietType()))
                .mealType(convertToStringSet(meal.getMealType()))
                .build();
    }

    /**
     * Converts Meal data transfer object to its Meal representation.
     *
     * @param mealDto The data transfer object to be converted.
     * @return An object of the Meal class representing the same meal as the data transfer object.
     */
    public Meal mapFromDto(MealDto mealDto) {
        return Meal.builder()
                .id(mealDto.getId())
                .name(mealDto.getName())
                .description((mealDto.getDescription()))
                .recipeLink(mealDto.getRecipeLink())
                .dietType(convertFromStringSet(mealDto.getDietType(), DietType.class))
                .mealType(convertFromStringSet(mealDto.getMealType(), MealType.class))
                .build();
    }

    private <E extends Enum<E>> Set<E> convertFromStringSet(Set<String> stringSet, Class<E> enumClass) {
        return stringSet.stream()
                .map(element -> E.valueOf(enumClass, element))
                .collect(Collectors.toSet());
    }

    private <E extends Enum<E>> Set<String> convertToStringSet(Set<? extends Enum<E>> enumSet) {
        return enumSet.stream()
                .map(Enum::name)
                .collect(Collectors.toSet());
    }

}
