package com.plates.controller;

import com.plates.dto.MealDto;
import com.plates.model.DietType;
import com.plates.model.MealType;
import com.plates.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    @GetMapping("/meals/{type}")
    List<MealDto> getMealsByType(@PathVariable String type) {

        List<String> dietTypes = DietType.getDietTypes();
        List<String> mealTypes = MealType.getMealTypes();

        if (dietTypes.contains(type)) { // TODO - może jakoś ładniej to
            DietType dietType = DietType.valueOf(type);
            return mealService.getMealsByType(dietType);
        } else if (mealTypes.contains(type)) {
            MealType mealType = MealType.valueOf(type);
            return mealService.getMealsByType(mealType);
        }

        return new ArrayList<>();
    }

    @GetMapping("/meals/meal/{meal_id}")
    MealDto getMealDetails(@PathVariable("meal_id") Long mealId) {
        return mealService.getMealDetailsById(mealId);
    }
}
