package com.plates.model;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum DietType {

    VEGAN,
    VEGETARIAN,
    MEAT_EATING,
    LOW_CALORIE;

    public static List<String> getDietTypes() {
        return Stream.of(DietType.values()).map(DietType::name).collect(Collectors.toList());
    }
}
