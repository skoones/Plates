package com.plates.service.impl;

import com.plates.dto.MealDto;
import com.plates.model.DietType;
import com.plates.model.Meal;
import com.plates.model.MealType;
import com.plates.service.MealService;
import com.plates.utility.mappers.MealDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MealServiceImpl implements MealService {

    @Override
    public List<MealDto> getAllMeals() {
        Meal tempMeal1 = Meal.builder()
                .id(1L)
                .name("jajeczniczka")
                .description("pyszniutka")
                .dietType(Set.of(DietType.VEGETARIAN))
                .mealType(Set.of(MealType.BREAKFAST))
                .build();

        Meal tempMeal2 = Meal.builder()
                .id(2L)
                .name("makaron ze szpinakiem i serem mmm")
                .description("top jedzonko")
                .recipeLink("www.szpinakiser.pl")
                .dietType(Set.of(DietType.VEGETARIAN))
                .mealType(Set.of(MealType.LUNCH))
                .build();


        List<Meal> meals = new ArrayList<>(List.of(tempMeal1, tempMeal2));

        return meals.stream().map(MealDtoMapper::mapToDto).collect(Collectors.toList());
    }

    @Override
    public <E extends Enum<E>> List<Meal> getMealsByType(E type) {
        return null;
    }

    @Override
    public Meal getMealDetails(Meal meal) {
        return null;
    }
}
