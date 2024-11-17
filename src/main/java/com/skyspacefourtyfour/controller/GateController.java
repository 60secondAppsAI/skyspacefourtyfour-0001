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

import com.skyspacefourtyfour.domain.Gate;
import com.skyspacefourtyfour.dto.GateDTO;
import com.skyspacefourtyfour.dto.GateSearchDTO;
import com.skyspacefourtyfour.dto.GatePageDTO;
import com.skyspacefourtyfour.service.GateService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/gate")
@RestController
public class GateController {

	private final static Logger logger = LoggerFactory.getLogger(GateController.class);

	@Autowired
	GateService gateService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Gate> getAll() {

		List<Gate> gates = gateService.findAll();
		
		return gates;	
	}

	@GetMapping(value = "/{gateId}")
	@ResponseBody
	public GateDTO getGate(@PathVariable Integer gateId) {
		
		return (gateService.getGateDTOById(gateId));
	}

 	@RequestMapping(value = "/addGate", method = RequestMethod.POST)
	public ResponseEntity<?> addGate(@RequestBody GateDTO gateDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = gateService.addGate(gateDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/gates")
	public ResponseEntity<GatePageDTO> getGates(GateSearchDTO gateSearchDTO) {
 
		return gateService.getGates(gateSearchDTO);
	}	

	@RequestMapping(value = "/updateGate", method = RequestMethod.POST)
	public ResponseEntity<?> updateGate(@RequestBody GateDTO gateDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = gateService.updateGate(gateDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
