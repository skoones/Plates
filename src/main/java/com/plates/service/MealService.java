package com.plates.service;

import com.plates.dto.MealDto;

import java.util.List;

public interface MealService {

    List<MealDto> getAllMeals();

    <E extends Enum<E>> List<MealDto> getMealsByType(E type);

    MealDto getMealDetailsById(Long id);

}
