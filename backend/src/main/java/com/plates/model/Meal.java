package com.plates.model;

import lombok.*;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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

    @Column(length = 1024)
    private String description;

    private String recipeLink;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @Enumerated(value = EnumType.STRING)
    private Set<MealType> mealType;

    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    @Enumerated(value = EnumType.STRING)
    private Set<DietType> dietType;

}
