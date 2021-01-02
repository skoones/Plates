package com.plates.runner;

import com.plates.dto.MealDto;
import com.plates.model.Meal;
import com.plates.repository.MealRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class AppRunner implements ApplicationRunner {

    public static final MealDto MEAL_DTO = MealDto.builder()
            .name("pyszna")
            .description("ffg")
            .recipeLink("www.pysznejedzonko.com")
            .mealType(Set.of("LUNCH"))
            .dietType(Set.of("VEGETARIAN"))
            .build();

    private final MealRepository mealRepository;

    @Override
    public void run(ApplicationArguments args) {
//        Meal meal = MealDtoMapper.mapFromDto(MEAL_DTO);
//
//        mealRepository.save(meal);

        List<Meal> meals = mealRepository.findAll();
        System.out.println(meals.isEmpty());
        System.out.println(meals);
    }
}
