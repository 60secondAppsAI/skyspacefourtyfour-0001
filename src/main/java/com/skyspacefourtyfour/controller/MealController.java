package com.skyspacefourtyfour.controller;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.ArrayList;


import com.skyspacefourtyfour.util.Util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.sql.Timestamp;
import java.util.Date;

import com.skyspacefourtyfour.domain.Meal;
import com.skyspacefourtyfour.dto.MealDTO;
import com.skyspacefourtyfour.dto.MealSearchDTO;
import com.skyspacefourtyfour.dto.MealPageDTO;
import com.skyspacefourtyfour.service.MealService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/meal")
@RestController
public class MealController {

	private final static Logger logger = LoggerFactory.getLogger(MealController.class);

	@Autowired
	MealService mealService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Meal> getAll() {

		List<Meal> meals = mealService.findAll();
		
		return meals;	
	}

	@GetMapping(value = "/{mealId}")
	@ResponseBody
	public MealDTO getMeal(@PathVariable Integer mealId) {
		
		return (mealService.getMealDTOById(mealId));
	}

 	@RequestMapping(value = "/addMeal", method = RequestMethod.POST)
	public ResponseEntity<?> addMeal(@RequestBody MealDTO mealDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = mealService.addMeal(mealDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/meals")
	public ResponseEntity<MealPageDTO> getMeals(MealSearchDTO mealSearchDTO) {
 
		return mealService.getMeals(mealSearchDTO);
	}	

	@RequestMapping(value = "/updateMeal", method = RequestMethod.POST)
	public ResponseEntity<?> updateMeal(@RequestBody MealDTO mealDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = mealService.updateMeal(mealDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
