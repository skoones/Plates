package com.plates.controller;

import com.plates.dto.MealDto;
import com.plates.model.MealType;
import com.plates.service.MealService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controller class responsible for handling URL requests.
 */
@CrossOrigin
@RestController
@AllArgsConstructor
@RequestMapping("/meals")
public class MealController {

    private final MealService mealService;

    /**
     * Returns all meals.
     *
     * @return List of all meals in the database.
     */
    @GetMapping("/")
    List<MealDto> getAllMeals() {
        return mealService.getAllMeals();
    }

    /**
     * Returns all meals of a certain type.
     *
     * @param type Type of meals we want to retrieve from the database.
     * @return List of all meals of a specific type (i. e. time of day, like breakfast).
     */
    @GetMapping("/type/{type}")
    List<MealDto> getMealsByMealType(@PathVariable String type) {
        MealType mealType = MealType.valueOf(type.toUpperCase());
        return mealService.getMealsByMealType(mealType);
    }

    /**
     * Returns meal with a given id.
     *
     * @param mealId Id of the meal we want to retrieve.
     * @return A meal of a given id.
     */
    @GetMapping("/{mealId}")
    MealDto getMealById(@PathVariable Long mealId) {
        return mealService.getMealById(mealId);
    }

    /**
     * Deletes meal with a given id.
     *
     * @param mealId Id of the meal we want to delete.
     */
    @DeleteMapping("/{mealId}")
    void deleteMealById(@PathVariable Long mealId) {
        mealService.deleteMealById(mealId);
    }

    /**
     * Adds meal to the database.
     *
     * @param mealDto Dto representing the meal we want to add to the database.
     */
    @PostMapping("/")
    void addMeal(@RequestBody MealDto mealDto) {
        mealService.addMeal(mealDto);
    }

    /**
     * Updates a selected meal.
     *
     * @param mealDto Dto representing the meal we want to update.
     */
    @PutMapping("/")
    void updateMeal(@RequestBody MealDto mealDto) {
        mealService.updateMeal(mealDto);
    }

}
