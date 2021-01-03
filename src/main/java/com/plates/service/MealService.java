package com.plates.service;

import com.plates.dto.MealDto;
import com.plates.model.MealType;

import java.util.List;

public interface MealService {

    List<MealDto> getAllMeals();

    List<MealDto> getMealsByMealType(MealType type);

    MealDto getMealDetailsById(Long id);

    void updateMeal(MealDto mealDto);

    void addMeal(MealDto mealDto);

    void deleteMealById(Long mealId);
}
