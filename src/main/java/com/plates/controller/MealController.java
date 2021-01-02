package com.plates.controller;

import com.plates.dto.MealDto;
import com.plates.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/meals")
public class MealController {

    public static final MealDto MEAL_DTO = MealDto.builder()
            .id(1L)
            .name("szakszuka pyszna")
            .description("bardzo dobra mniam")
            .recipeLink("www.pysznejedzonko.com")
            .mealType(new ArrayList<>(List.of("LUNCH")))
            .dietType(new ArrayList<>(List.of("VEGETARIAN")))
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
