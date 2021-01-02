package com.plates.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Meal {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false, unique = true)
    @EqualsAndHashCode.Include
    private String name;

    private String description;

    private String recipeLink;

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private Set<MealType> mealType;

    @ElementCollection
    @Enumerated(value = EnumType.STRING)
    private Set<DietType> dietType;
}
