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

import com.skyspacefourtyfour.domain.Schedule;
import com.skyspacefourtyfour.dto.ScheduleDTO;
import com.skyspacefourtyfour.dto.ScheduleSearchDTO;
import com.skyspacefourtyfour.dto.SchedulePageDTO;
import com.skyspacefourtyfour.service.ScheduleService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;




@CrossOrigin(origins = "*")
@RequestMapping("/schedule")
@RestController
public class ScheduleController {

	private final static Logger logger = LoggerFactory.getLogger(ScheduleController.class);

	@Autowired
	ScheduleService scheduleService;



	@RequestMapping(value="/", method = RequestMethod.GET)
	public List<Schedule> getAll() {

		List<Schedule> schedules = scheduleService.findAll();
		
		return schedules;	
	}

	@GetMapping(value = "/{scheduleId}")
	@ResponseBody
	public ScheduleDTO getSchedule(@PathVariable Integer scheduleId) {
		
		return (scheduleService.getScheduleDTOById(scheduleId));
	}

 	@RequestMapping(value = "/addSchedule", method = RequestMethod.POST)
	public ResponseEntity<?> addSchedule(@RequestBody ScheduleDTO scheduleDTO, HttpServletRequest request) {

		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = scheduleService.addSchedule(scheduleDTO, requestDTO);
		
		return result.asResponseEntity();
	}

	@GetMapping("/schedules")
	public ResponseEntity<SchedulePageDTO> getSchedules(ScheduleSearchDTO scheduleSearchDTO) {
 
		return scheduleService.getSchedules(scheduleSearchDTO);
	}	

	@RequestMapping(value = "/updateSchedule", method = RequestMethod.POST)
	public ResponseEntity<?> updateSchedule(@RequestBody ScheduleDTO scheduleDTO, HttpServletRequest request) {
		RequestDTO requestDTO = new RequestDTO(request);
		ResultDTO result = scheduleService.updateSchedule(scheduleDTO, requestDTO);
		
//		if (result.isSuccessful()) {
//		}

		return result.asResponseEntity();
	}



}
