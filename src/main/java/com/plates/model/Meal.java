package com.plates.model;

import lombok.Data;

//@Entity
//@Data
public class Meal {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, unique = true)
    private String name;

    private String description;

    private String recipeLink;

//    @Enumerated(EnumType.STRING)
    private MealType mealType;

//    @Enumerated(EnumType.STRING)
    private DietType dietType;
}
