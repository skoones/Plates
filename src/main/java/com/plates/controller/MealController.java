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

    @GetMapping("/type/{type}")
    List<MealDto> getMealsByMealType(@PathVariable String type) {
        MealType mealType = MealType.valueOf(type.toUpperCase());
        return mealService.getMealsByMealType(mealType);
    }

    @GetMapping("/{mealId}")
    MealDto getMeal(@PathVariable Long mealId) {
        return mealService.getMealById(mealId);
    }

    @DeleteMapping("/{mealId}")
    void deleteMeal(@PathVariable Long mealId) {
        mealService.deleteMealById(mealId);
    }

    @PostMapping("/")
    void addMeal(@RequestBody MealDto mealDto) {
        mealService.addMeal(mealDto);
    }

    @PutMapping("/")
    void updateMeal(@RequestBody MealDto mealDto) {
        mealService.updateMeal(mealDto);
    }
}
