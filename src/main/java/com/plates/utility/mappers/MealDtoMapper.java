package com.plates.utility.mappers;

import com.plates.dto.MealDto;
import com.plates.model.DietType;
import com.plates.model.Meal;
import com.plates.model.MealType;
import lombok.experimental.UtilityClass;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class MealDtoMapper {

    public MealDto mapToDto(Meal meal) {
        return MealDto.builder()
                .id(meal.getId())
                .name(meal.getName())
                .description(meal.getDescription())
                .recipeLink(meal.getRecipeLink())
                .dietType(convertFromEnumList(meal.getDietType()))
                .mealType(convertFromEnumList(meal.getMealType()))
                .build();
    }

    public Meal mapFromDto(MealDto mealDto) {
        return Meal.builder()
                .id(mealDto.getId())
                .name(mealDto.getName())
                .description((mealDto.getDescription()))
                .recipeLink(mealDto.getRecipeLink())
                .dietType(convertToEnumList(mealDto.getDietType(), DietType.class))
                .mealType(convertToEnumList(mealDto.getMealType(), MealType.class))
                .build();
    }

    private <E extends Enum<E>> List<E> convertToEnumList(List<String> stringList, Class<E> enumClass) {
        return stringList.stream().map(element -> E.valueOf(enumClass, element)).collect(Collectors.toList());
    }

    private <E extends Enum<E>> List<String> convertFromEnumList(List<? extends Enum<E>> enumList) {
        return enumList.stream().map(Enum::name).collect(Collectors.toList());
    }
}
