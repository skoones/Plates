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
                .dietType(convertFromEnumSet(meal.getDietType()))
                .mealType(convertFromEnumSet(meal.getMealType()))
                .build();
    }

    public Meal mapFromDto(MealDto mealDto) {
        return Meal.builder()
                .name(mealDto.getName())
                .description((mealDto.getDescription()))
                .recipeLink(mealDto.getRecipeLink())
                .dietType(convertToEnumSet(mealDto.getDietType(), DietType.class))
                .mealType(convertToEnumSet(mealDto.getMealType(), MealType.class))
                .build();
    }

    private <E extends Enum<E>> Set<E> convertToEnumSet(Set<String> stringSet, Class<E> enumClass) {
        return stringSet.stream().map(element -> E.valueOf(enumClass, element)).collect(Collectors.toSet());
    }

    private <E extends Enum<E>> Set<String> convertFromEnumSet(Set<? extends Enum<E>> enumSet) {
        return enumSet.stream().map(Enum::name).collect(Collectors.toSet());
    }
}
