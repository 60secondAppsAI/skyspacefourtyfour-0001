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

import com.skyspacefourtyfour.domain.Airport;
import com.skyspacefourtyfour.dto.AirportDTO;
import com.skyspacefourtyfour.dto.AirportSearchDTO;
import com.skyspacefourtyfour.dto.AirportPageDTO;
import com.skyspacefourtyfour.service.AirportService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/airport")
@RestController
public class AirportController {

	private final static Logger logger = LoggerFactory.getLogger(AirportController.class);

	@Autowired
	AirportService airportService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Airport> getAll() {

		List<Airport> airports = airportService.findAll();
		
		return airports;	
	}

	@GetMapping(value = "/{airportId}")
	@ResponseBody
	public AirportDTO getAirport(@PathVariable Integer airportId) {
		
		return (airportService.getAirportDTOById(airportId));
	}

 	@RequestMapping(value = "/addAirport", method = RequestMethod.POST)
	public ResponseEntity<?> addAirport(@RequestBody AirportDTO airportDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = airportService.addAirport(airportDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/airports")
	public ResponseEntity<AirportPageDTO> getAirports(AirportSearchDTO airportSearchDTO) {
 
		return airportService.getAirports(airportSearchDTO);
	}	

	@RequestMapping(value = "/updateAirport", method = RequestMethod.POST)
	public ResponseEntity<?> updateAirport(@RequestBody AirportDTO airportDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = airportService.updateAirport(airportDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
