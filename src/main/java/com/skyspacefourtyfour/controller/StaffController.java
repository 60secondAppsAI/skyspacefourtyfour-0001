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

import com.skyspacefourtyfour.domain.Staff;
import com.skyspacefourtyfour.dto.StaffDTO;
import com.skyspacefourtyfour.dto.StaffSearchDTO;
import com.skyspacefourtyfour.dto.StaffPageDTO;
import com.skyspacefourtyfour.service.StaffService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/staff")
@RestController
public class StaffController {

	private final static Logger logger = LoggerFactory.getLogger(StaffController.class);

	@Autowired
	StaffService staffService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Staff> getAll() {

		List<Staff> staffs = staffService.findAll();
		
		return staffs;	
	}

	@GetMapping(value = "/{staffId}")
	@ResponseBody
	public StaffDTO getStaff(@PathVariable Integer staffId) {
		
		return (staffService.getStaffDTOById(staffId));
	}

 	@RequestMapping(value = "/addStaff", method = RequestMethod.POST)
	public ResponseEntity<?> addStaff(@RequestBody StaffDTO staffDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = staffService.addStaff(staffDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/staffs")
	public ResponseEntity<StaffPageDTO> getStaffs(StaffSearchDTO staffSearchDTO) {
 
		return staffService.getStaffs(staffSearchDTO);
	}	

	@RequestMapping(value = "/updateStaff", method = RequestMethod.POST)
	public ResponseEntity<?> updateStaff(@RequestBody StaffDTO staffDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = staffService.updateStaff(staffDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
