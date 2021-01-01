package com.plates.utility.mappers;

import com.plates.dto.MealDto;
import com.plates.model.Meal;
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
                .dietType(convertEnumList(meal.getDietType()))
                .mealType(convertEnumList(meal.getMealType()))
                .build();
    }

    private <E extends Enum<E>> List<String> convertEnumList(List<? extends Enum<E>> enumList) {
        return enumList.stream().map(Enum::name).collect(Collectors.toList());
    }
}
