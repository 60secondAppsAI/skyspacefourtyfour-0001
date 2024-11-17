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

import com.skyspacefourtyfour.domain.BaggageClaim;
import com.skyspacefourtyfour.dto.BaggageClaimDTO;
import com.skyspacefourtyfour.dto.BaggageClaimSearchDTO;
import com.skyspacefourtyfour.dto.BaggageClaimPageDTO;
import com.skyspacefourtyfour.service.BaggageClaimService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/baggageClaim")
@RestController
public class BaggageClaimController {

	private final static Logger logger = LoggerFactory.getLogger(BaggageClaimController.class);

	@Autowired
	BaggageClaimService baggageClaimService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<BaggageClaim> getAll() {

		List<BaggageClaim> baggageClaims = baggageClaimService.findAll();
		
		return baggageClaims;	
	}

	@GetMapping(value = "/{baggageClaimId}")
	@ResponseBody
	public BaggageClaimDTO getBaggageClaim(@PathVariable Integer baggageClaimId) {
		
		return (baggageClaimService.getBaggageClaimDTOById(baggageClaimId));
	}

 	@RequestMapping(value = "/addBaggageClaim", method = RequestMethod.POST)
	public ResponseEntity<?> addBaggageClaim(@RequestBody BaggageClaimDTO baggageClaimDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = baggageClaimService.addBaggageClaim(baggageClaimDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/baggageClaims")
	public ResponseEntity<BaggageClaimPageDTO> getBaggageClaims(BaggageClaimSearchDTO baggageClaimSearchDTO) {
 
		return baggageClaimService.getBaggageClaims(baggageClaimSearchDTO);
	}	

	@RequestMapping(value = "/updateBaggageClaim", method = RequestMethod.POST)
	public ResponseEntity<?> updateBaggageClaim(@RequestBody BaggageClaimDTO baggageClaimDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = baggageClaimService.updateBaggageClaim(baggageClaimDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
