package com.plates.controller;

import com.plates.dto.MealDto;
import com.plates.model.MealType;
import com.plates.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
        MealType mealType = MealType.valueOf(type.toUpperCase());
        return mealService.getMealsByMealType(mealType);
    }

    @GetMapping("/meal/{meal_id}")
    MealDto getMealDetails(@PathVariable("meal_id") Long mealId) {
        return mealService.getMealDetailsById(mealId);
    }

    @PutMapping("/meal/update")
    void updateMealDetails(@RequestBody MealDto mealDto) {
        mealService.updateMeal(mealDto);
    }

    @PostMapping("/")
    void addMeal(@RequestBody MealDto mealDto) {
        mealService.addMeal(mealDto);
    }
}
