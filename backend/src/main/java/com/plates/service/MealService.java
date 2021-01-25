package com.plates.service;

import com.plates.dto.MealDto;
import com.plates.model.MealType;

import java.util.List;

/**
 * Service responsible for business logic in the MealController class.
 */
public interface MealService {

    /**
     * Retrieves all meals from the database.
     *
     * @return List of all meals in the database.
     */
    List<MealDto> getAllMeals();

    /**
     * Retrieves all meals of a specified type.
     *
     * @param type Desired meal type, e.g. breakfast.
     * @return List of all meals of a given type.
     */
    List<MealDto> getMealsByMealType(MealType type);

    /**
     * Retrieves meal with a given id.
     *
     * @param id Id of the meal we want to retrieve.
     * @return The meal we want to retrieve.
     */
    MealDto getMealById(Long id);

    /**
     * Deletes meal with a given id.
     *
     * @param mealId Id of the meal we want to delete.
     */
    void deleteMealById(Long mealId);

    /**
     * Adds meal to the database.
     *
     * @param mealDto Data transfer object representing the meal we want to add.
     */
    void addMeal(MealDto mealDto);

    /**
     * Updates given meal.
     *
     * @param mealDto Data transfer object representing the updated version of the meal.
     */
    void updateMeal(MealDto mealDto);

}
