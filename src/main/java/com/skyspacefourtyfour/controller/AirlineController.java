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

import com.skyspacefourtyfour.domain.Airline;
import com.skyspacefourtyfour.dto.AirlineDTO;
import com.skyspacefourtyfour.dto.AirlineSearchDTO;
import com.skyspacefourtyfour.dto.AirlinePageDTO;
import com.skyspacefourtyfour.service.AirlineService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/airline")
@RestController
public class AirlineController {

	private final static Logger logger = LoggerFactory.getLogger(AirlineController.class);

	@Autowired
	AirlineService airlineService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Airline> getAll() {

		List<Airline> airlines = airlineService.findAll();
		
		return airlines;	
	}

	@GetMapping(value = "/{airlineId}")
	@ResponseBody
	public AirlineDTO getAirline(@PathVariable Integer airlineId) {
		
		return (airlineService.getAirlineDTOById(airlineId));
	}

 	@RequestMapping(value = "/addAirline", method = RequestMethod.POST)
	public ResponseEntity<?> addAirline(@RequestBody AirlineDTO airlineDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = airlineService.addAirline(airlineDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/airlines")
	public ResponseEntity<AirlinePageDTO> getAirlines(AirlineSearchDTO airlineSearchDTO) {
 
		return airlineService.getAirlines(airlineSearchDTO);
	}	

	@RequestMapping(value = "/updateAirline", method = RequestMethod.POST)
	public ResponseEntity<?> updateAirline(@RequestBody AirlineDTO airlineDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = airlineService.updateAirline(airlineDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
