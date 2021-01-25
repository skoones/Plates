package com.plates.repository;

import com.plates.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface for performing database operations using JPA.
 */
public interface MealRepository extends JpaRepository<Meal, Long> {
}
