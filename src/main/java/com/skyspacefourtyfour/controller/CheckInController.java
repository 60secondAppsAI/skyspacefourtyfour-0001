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

import com.skyspacefourtyfour.domain.CheckIn;
import com.skyspacefourtyfour.dto.CheckInDTO;
import com.skyspacefourtyfour.dto.CheckInSearchDTO;
import com.skyspacefourtyfour.dto.CheckInPageDTO;
import com.skyspacefourtyfour.service.CheckInService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/checkIn")
@RestController
public class CheckInController {

	private final static Logger logger = LoggerFactory.getLogger(CheckInController.class);

	@Autowired
	CheckInService checkInService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<CheckIn> getAll() {

		List<CheckIn> checkIns = checkInService.findAll();
		
		return checkIns;	
	}

	@GetMapping(value = "/{checkInId}")
	@ResponseBody
	public CheckInDTO getCheckIn(@PathVariable Integer checkInId) {
		
		return (checkInService.getCheckInDTOById(checkInId));
	}

 	@RequestMapping(value = "/addCheckIn", method = RequestMethod.POST)
	public ResponseEntity<?> addCheckIn(@RequestBody CheckInDTO checkInDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = checkInService.addCheckIn(checkInDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/checkIns")
	public ResponseEntity<CheckInPageDTO> getCheckIns(CheckInSearchDTO checkInSearchDTO) {
 
		return checkInService.getCheckIns(checkInSearchDTO);
	}	

	@RequestMapping(value = "/updateCheckIn", method = RequestMethod.POST)
	public ResponseEntity<?> updateCheckIn(@RequestBody CheckInDTO checkInDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = checkInService.updateCheckIn(checkInDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
