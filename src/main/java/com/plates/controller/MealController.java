package com.plates.controller;

import com.plates.dto.MealDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
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


    @GetMapping("/hello")
    MealDto getHelloWorld() {
        return MEAL_DTO;
    }
}
