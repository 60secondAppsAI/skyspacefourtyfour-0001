package com.skyspacefourtyfour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefourtyfour.domain.Meal;
import com.skyspacefourtyfour.dto.MealDTO;
import com.skyspacefourtyfour.dto.MealSearchDTO;
import com.skyspacefourtyfour.dto.MealPageDTO;
import com.skyspacefourtyfour.dto.MealConvertCriteriaDTO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface MealService extends GenericService<Meal, Integer> {

	List<Meal> findAll();

	ResultDTO addMeal(MealDTO mealDTO, RequestDTO requestDTO);

	ResultDTO updateMeal(MealDTO mealDTO, RequestDTO requestDTO);

    Page<Meal> getAllMeals(Pageable pageable);

    Page<Meal> getAllMeals(Specification<Meal> spec, Pageable pageable);

	ResponseEntity<MealPageDTO> getMeals(MealSearchDTO mealSearchDTO);
	
	List<MealDTO> convertMealsToMealDTOs(List<Meal> meals, MealConvertCriteriaDTO convertCriteria);

	MealDTO getMealDTOById(Integer mealId);







}





