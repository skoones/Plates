package com.plates.controller;

import com.plates.dto.MealDto;
import com.plates.model.MealType;
import com.plates.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/meals")
public class MealController {

    private final MealService mealService;

    @GetMapping("/")
    List<MealDto> getMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/{type}")
    List<MealDto> getMealsByMealType(@PathVariable String type) {
        MealType mealType = MealType.valueOf(type);
        return mealService.getMealsByType(mealType);
    }

    @GetMapping("/meal/{meal_id}")
    MealDto getMealDetails(@PathVariable("meal_id") Long mealId) {
        return mealService.getMealDetailsById(mealId);
    }
}
