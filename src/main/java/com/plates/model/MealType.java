package com.plates.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum MealType {

    BREAKFAST,
    LUNCH,
    DINNER,
    SNACK;

    public static List<String> getMealTypes() {
        return Stream.of(MealType.values()).map(MealType::name).collect(Collectors.toList());
    }
}
