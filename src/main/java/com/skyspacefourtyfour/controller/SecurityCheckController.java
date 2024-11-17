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

import com.skyspacefourtyfour.domain.SecurityCheck;
import com.skyspacefourtyfour.dto.SecurityCheckDTO;
import com.skyspacefourtyfour.dto.SecurityCheckSearchDTO;
import com.skyspacefourtyfour.dto.SecurityCheckPageDTO;
import com.skyspacefourtyfour.service.SecurityCheckService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/securityCheck")
@RestController
public class SecurityCheckController {

	private final static Logger logger = LoggerFactory.getLogger(SecurityCheckController.class);

	@Autowired
	SecurityCheckService securityCheckService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<SecurityCheck> getAll() {

		List<SecurityCheck> securityChecks = securityCheckService.findAll();
		
		return securityChecks;	
	}

	@GetMapping(value = "/{securityCheckId}")
	@ResponseBody
	public SecurityCheckDTO getSecurityCheck(@PathVariable Integer securityCheckId) {
		
		return (securityCheckService.getSecurityCheckDTOById(securityCheckId));
	}

 	@RequestMapping(value = "/addSecurityCheck", method = RequestMethod.POST)
	public ResponseEntity<?> addSecurityCheck(@RequestBody SecurityCheckDTO securityCheckDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = securityCheckService.addSecurityCheck(securityCheckDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/securityChecks")
	public ResponseEntity<SecurityCheckPageDTO> getSecurityChecks(SecurityCheckSearchDTO securityCheckSearchDTO) {
 
		return securityCheckService.getSecurityChecks(securityCheckSearchDTO);
	}	

	@RequestMapping(value = "/updateSecurityCheck", method = RequestMethod.POST)
	public ResponseEntity<?> updateSecurityCheck(@RequestBody SecurityCheckDTO securityCheckDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = securityCheckService.updateSecurityCheck(securityCheckDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
