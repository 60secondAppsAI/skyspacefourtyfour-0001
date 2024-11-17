package com.skyspacefourtyfour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefourtyfour.domain.Fleet;
import com.skyspacefourtyfour.dto.FleetDTO;
import com.skyspacefourtyfour.dto.FleetSearchDTO;
import com.skyspacefourtyfour.dto.FleetPageDTO;
import com.skyspacefourtyfour.dto.FleetConvertCriteriaDTO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface FleetService extends GenericService<Fleet, Integer> {

	List<Fleet> findAll();

	ResultDTO addFleet(FleetDTO fleetDTO, RequestDTO requestDTO);

	ResultDTO updateFleet(FleetDTO fleetDTO, RequestDTO requestDTO);

    Page<Fleet> getAllFleets(Pageable pageable);

    Page<Fleet> getAllFleets(Specification<Fleet> spec, Pageable pageable);

	ResponseEntity<FleetPageDTO> getFleets(FleetSearchDTO fleetSearchDTO);
	
	List<FleetDTO> convertFleetsToFleetDTOs(List<Fleet> fleets, FleetConvertCriteriaDTO convertCriteria);

	FleetDTO getFleetDTOById(Integer fleetId);







}





