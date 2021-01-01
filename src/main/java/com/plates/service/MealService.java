package com.plates.service;

import com.plates.dto.MealDto;
import com.plates.model.Meal;

import java.util.List;

public interface MealService {

    List<MealDto> getAllMeals();

    <E extends Enum<E>> List<Meal> getMealsByType(E type);

    Meal getMealDetails(Meal meal);

}
