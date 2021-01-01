package com.plates.model;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

//@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
public class Meal {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    //    @Column(nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private String name;

    private String description;

    @EqualsAndHashCode.Include
    private String recipeLink;

    //    @Enumerated(EnumType.STRING)
    private List<MealType> mealType;

    //    @Enumerated(EnumType.STRING)
    private List<DietType> dietType;
}
