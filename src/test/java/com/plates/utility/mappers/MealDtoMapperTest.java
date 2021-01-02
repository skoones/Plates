package com.plates.utility.mappers;

import com.plates.dto.MealDto;
import com.plates.model.DietType;
import com.plates.model.Meal;
import com.plates.model.MealType;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MealDtoMapperTest {

    private static final Meal TEST_MEAL = Meal.builder()
            .id(1L)
            .name("szakszuka pyszna")
            .description("exquisite jedzonko")
            .recipeLink("www.pysznejedzonko.com")
            .dietType(Set.of(DietType.VEGETARIAN))
            .mealType(Set.of(MealType.BREAKFAST, MealType.LUNCH))
            .build();

    private static final MealDto TEST_MEAL_DTO = MealDto.builder()
            .id(1L)
            .name("szakszuka pyszna")
            .description("exquisite jedzonko")
            .recipeLink("www.pysznejedzonko.com")
            .dietType(Set.of("VEGETARIAN"))
            .mealType(Set.of("BREAKFAST", "LUNCH"))
            .build();

    @Test
    public void shouldMapEntityToDto() {
        // given
        Meal meal = TEST_MEAL;

        // when
        MealDto mealDto = MealDtoMapper.mapToDto(meal);

        // then
        assertEquals(meal.getId(), mealDto.getId());
        assertEquals(meal.getName(), mealDto.getName());
        assertEquals(meal.getDescription(), mealDto.getDescription());
        assertEquals(meal.getRecipeLink(), mealDto.getRecipeLink());
        assertEquals(Set.of("VEGETARIAN"), mealDto.getDietType());
        assertEquals(Set.of("BREAKFAST", "LUNCH"), mealDto.getMealType());
    }

    @Test
    public void shouldMapDtoToEntity() {
        // given
        MealDto mealDto = TEST_MEAL_DTO;

        // when
        Meal meal = MealDtoMapper.mapFromDto(mealDto);

        // then
        assertEquals(meal.getName(), mealDto.getName());
        assertEquals(meal.getDescription(), mealDto.getDescription());
        assertEquals(meal.getRecipeLink(), mealDto.getRecipeLink());
        assertEquals(Set.of(DietType.VEGETARIAN), meal.getDietType());
        assertEquals(Set.of(MealType.BREAKFAST, MealType.LUNCH), meal.getMealType());
    }

}