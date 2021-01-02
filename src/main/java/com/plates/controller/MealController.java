package com.plates.controller;

import com.plates.dto.MealDto;
import com.plates.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RestController
@AllArgsConstructor
@RequestMapping("/meals")
public class MealController {

    public static final MealDto MEAL_DTO = MealDto.builder()
            .id(1L)
            .name("szakszuka pyszna")
            .description("bardzo dobra mniam")
            .recipeLink("www.pysznejedzonko.com")
            .mealType(Set.of("LUNCH"))
            .dietType(Set.of("VEGETARIAN"))
            .build();

    private final MealService mealService;

    @PostMapping("/hello")
    void postHelloWorld(@RequestBody MealDto mealDto) {
        System.out.println(mealDto);
    }

    @GetMapping("/hello")
    MealDto getHelloWorld() {
        return MEAL_DTO;
    }

    @GetMapping("/")
    List<MealDto> getMeals() {
        return mealService.getAllMeals();
    }
}
