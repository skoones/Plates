package com.plates.utility.mappers;

import com.plates.dto.MealDto;
import com.plates.model.DietType;
import com.plates.model.Meal;
import com.plates.model.MealType;
import lombok.experimental.UtilityClass;

import java.util.Set;
import java.util.stream.Collectors;

@UtilityClass
public class MealDtoMapper {

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
                .map(String::toUpperCase)
                .map(element -> E.valueOf(enumClass, element))
                .collect(Collectors.toSet());
    }

    private <E extends Enum<E>> Set<String> convertToStringSet(Set<? extends Enum<E>> enumSet) {
        return enumSet.stream()
                .map(Enum::name)
                .map(String::toLowerCase)
                .collect(Collectors.toSet());
    }

}
