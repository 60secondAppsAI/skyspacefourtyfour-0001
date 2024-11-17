package com.skyspacefourtyfour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefourtyfour.domain.Staff;
import com.skyspacefourtyfour.dto.StaffDTO;
import com.skyspacefourtyfour.dto.StaffSearchDTO;
import com.skyspacefourtyfour.dto.StaffPageDTO;
import com.skyspacefourtyfour.dto.StaffConvertCriteriaDTO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface StaffService extends GenericService<Staff, Integer> {

	List<Staff> findAll();

	ResultDTO addStaff(StaffDTO staffDTO, RequestDTO requestDTO);

	ResultDTO updateStaff(StaffDTO staffDTO, RequestDTO requestDTO);

    Page<Staff> getAllStaffs(Pageable pageable);

    Page<Staff> getAllStaffs(Specification<Staff> spec, Pageable pageable);

	ResponseEntity<StaffPageDTO> getStaffs(StaffSearchDTO staffSearchDTO);
	
	List<StaffDTO> convertStaffsToStaffDTOs(List<Staff> staffs, StaffConvertCriteriaDTO convertCriteria);

	StaffDTO getStaffDTOById(Integer staffId);







}





