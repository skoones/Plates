package com.plates.service;

import com.plates.dto.MealDto;
import com.plates.model.MealType;

import java.util.List;

public interface MealService {

    List<MealDto> getAllMeals();

    List<MealDto> getMealsByMealType(MealType type);

    MealDto getMealById(Long id);

    void deleteMealById(Long mealId);

    void addMeal(MealDto mealDto);

    void updateMeal(MealDto mealDto);

}
