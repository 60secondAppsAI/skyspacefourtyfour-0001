package com.skyspacefourtyfour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefourtyfour.domain.Airport;
import com.skyspacefourtyfour.dto.AirportDTO;
import com.skyspacefourtyfour.dto.AirportSearchDTO;
import com.skyspacefourtyfour.dto.AirportPageDTO;
import com.skyspacefourtyfour.dto.AirportConvertCriteriaDTO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface AirportService extends GenericService<Airport, Integer> {

	List<Airport> findAll();

	ResultDTO addAirport(AirportDTO airportDTO, RequestDTO requestDTO);

	ResultDTO updateAirport(AirportDTO airportDTO, RequestDTO requestDTO);

    Page<Airport> getAllAirports(Pageable pageable);

    Page<Airport> getAllAirports(Specification<Airport> spec, Pageable pageable);

	ResponseEntity<AirportPageDTO> getAirports(AirportSearchDTO airportSearchDTO);
	
	List<AirportDTO> convertAirportsToAirportDTOs(List<Airport> airports, AirportConvertCriteriaDTO convertCriteria);

	AirportDTO getAirportDTOById(Integer airportId);







}





