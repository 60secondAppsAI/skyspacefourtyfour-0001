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

import com.skyspacefourtyfour.domain.Lounge;
import com.skyspacefourtyfour.dto.LoungeDTO;
import com.skyspacefourtyfour.dto.LoungeSearchDTO;
import com.skyspacefourtyfour.dto.LoungePageDTO;
import com.skyspacefourtyfour.service.LoungeService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/lounge")
@RestController
public class LoungeController {

	private final static Logger logger = LoggerFactory.getLogger(LoungeController.class);

	@Autowired
	LoungeService loungeService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Lounge> getAll() {

		List<Lounge> lounges = loungeService.findAll();
		
		return lounges;	
	}

	@GetMapping(value = "/{loungeId}")
	@ResponseBody
	public LoungeDTO getLounge(@PathVariable Integer loungeId) {
		
		return (loungeService.getLoungeDTOById(loungeId));
	}

 	@RequestMapping(value = "/addLounge", method = RequestMethod.POST)
	public ResponseEntity<?> addLounge(@RequestBody LoungeDTO loungeDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = loungeService.addLounge(loungeDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/lounges")
	public ResponseEntity<LoungePageDTO> getLounges(LoungeSearchDTO loungeSearchDTO) {
 
		return loungeService.getLounges(loungeSearchDTO);
	}	

	@RequestMapping(value = "/updateLounge", method = RequestMethod.POST)
	public ResponseEntity<?> updateLounge(@RequestBody LoungeDTO loungeDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = loungeService.updateLounge(loungeDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}