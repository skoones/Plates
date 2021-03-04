package com.plates.controller;

import com.plates.dto.MealDto;
import com.plates.model.MealType;
import com.plates.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/meals")
public class MealController {

    private final MealService mealService;

    @GetMapping("/")
    public List<MealDto> getAllMeals() {
        return mealService.getAllMeals();
    }

    @GetMapping("/type/{type}")
    public List<MealDto> getMealsByMealType(@PathVariable String type) {
        MealType mealType = MealType.valueOf(type.toUpperCase());
        return mealService.getMealsByMealType(mealType);
    }

    @GetMapping("/{mealId}")
    public MealDto getMealById(@PathVariable Long mealId) {
        return mealService.getMealById(mealId);
    }

    @DeleteMapping("/{mealId}")
    public void deleteMealById(@PathVariable Long mealId) {
        mealService.deleteMealById(mealId);
    }

    @PostMapping("/")
    public void addMeal(@RequestBody MealDto mealDto) {
        mealService.addMeal(mealDto);
    }

    @PutMapping("/")
    public void updateMeal(@RequestBody MealDto mealDto) {
        mealService.updateMeal(mealDto);
    }

}
