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

import com.skyspacefourtyfour.domain.Luggage;
import com.skyspacefourtyfour.dto.LuggageDTO;
import com.skyspacefourtyfour.dto.LuggageSearchDTO;
import com.skyspacefourtyfour.dto.LuggagePageDTO;
import com.skyspacefourtyfour.service.LuggageService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/luggage")
@RestController
public class LuggageController {

	private final static Logger logger = LoggerFactory.getLogger(LuggageController.class);

	@Autowired
	LuggageService luggageService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Luggage> getAll() {

		List<Luggage> luggages = luggageService.findAll();
		
		return luggages;	
	}

	@GetMapping(value = "/{luggageId}")
	@ResponseBody
	public LuggageDTO getLuggage(@PathVariable Integer luggageId) {
		
		return (luggageService.getLuggageDTOById(luggageId));
	}

 	@RequestMapping(value = "/addLuggage", method = RequestMethod.POST)
	public ResponseEntity<?> addLuggage(@RequestBody LuggageDTO luggageDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = luggageService.addLuggage(luggageDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/luggages")
	public ResponseEntity<LuggagePageDTO> getLuggages(LuggageSearchDTO luggageSearchDTO) {
 
		return luggageService.getLuggages(luggageSearchDTO);
	}	

	@RequestMapping(value = "/updateLuggage", method = RequestMethod.POST)
	public ResponseEntity<?> updateLuggage(@RequestBody LuggageDTO luggageDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = luggageService.updateLuggage(luggageDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
