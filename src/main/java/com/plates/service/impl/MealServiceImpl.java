package com.plates.service.impl;

import com.plates.dto.MealDto;
import com.plates.model.MealType;
import com.plates.repository.MealRepository;
import com.plates.service.MealService;
import com.plates.utility.mappers.MealDtoMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    @Override
    public List<MealDto> getAllMeals() {

        return mealRepository.findAll().stream()
                .map(MealDtoMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<MealDto> getMealsByMealType(MealType type) {
        return mealRepository.findAll()
                .stream()
                .filter(meal -> meal.getMealType().contains(type))
                .map(MealDtoMapper::mapToDto)
                .collect(Collectors.toList());

    }

    @Override
    public MealDto getMealDetailsById(Long id) {
        return mealRepository.findById(id)
                .map(MealDtoMapper::mapToDto)
                .orElseThrow();
    }

    @Override
    public void updateMeal(MealDto mealDto) {
        mealRepository.findById(mealDto.getId()).orElseThrow();

        mealRepository.save(MealDtoMapper.mapFromDto(mealDto));
    }

    @Override
    public void addMeal(MealDto mealDto) {
        mealRepository.save(MealDtoMapper.mapFromDto(mealDto));
    }
}
