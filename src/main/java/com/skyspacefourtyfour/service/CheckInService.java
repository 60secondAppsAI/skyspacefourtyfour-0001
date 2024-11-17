package com.skyspacefourtyfour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefourtyfour.domain.CheckIn;
import com.skyspacefourtyfour.dto.CheckInDTO;
import com.skyspacefourtyfour.dto.CheckInSearchDTO;
import com.skyspacefourtyfour.dto.CheckInPageDTO;
import com.skyspacefourtyfour.dto.CheckInConvertCriteriaDTO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface CheckInService extends GenericService<CheckIn, Integer> {

	List<CheckIn> findAll();

	ResultDTO addCheckIn(CheckInDTO checkInDTO, RequestDTO requestDTO);

	ResultDTO updateCheckIn(CheckInDTO checkInDTO, RequestDTO requestDTO);

    Page<CheckIn> getAllCheckIns(Pageable pageable);

    Page<CheckIn> getAllCheckIns(Specification<CheckIn> spec, Pageable pageable);

	ResponseEntity<CheckInPageDTO> getCheckIns(CheckInSearchDTO checkInSearchDTO);
	
	List<CheckInDTO> convertCheckInsToCheckInDTOs(List<CheckIn> checkIns, CheckInConvertCriteriaDTO convertCriteria);

	CheckInDTO getCheckInDTOById(Integer checkInId);







}





