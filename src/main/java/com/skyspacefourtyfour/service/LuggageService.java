package com.skyspacefourtyfour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefourtyfour.domain.Luggage;
import com.skyspacefourtyfour.dto.LuggageDTO;
import com.skyspacefourtyfour.dto.LuggageSearchDTO;
import com.skyspacefourtyfour.dto.LuggagePageDTO;
import com.skyspacefourtyfour.dto.LuggageConvertCriteriaDTO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface LuggageService extends GenericService<Luggage, Integer> {

	List<Luggage> findAll();

	ResultDTO addLuggage(LuggageDTO luggageDTO, RequestDTO requestDTO);

	ResultDTO updateLuggage(LuggageDTO luggageDTO, RequestDTO requestDTO);

    Page<Luggage> getAllLuggages(Pageable pageable);

    Page<Luggage> getAllLuggages(Specification<Luggage> spec, Pageable pageable);

	ResponseEntity<LuggagePageDTO> getLuggages(LuggageSearchDTO luggageSearchDTO);
	
	List<LuggageDTO> convertLuggagesToLuggageDTOs(List<Luggage> luggages, LuggageConvertCriteriaDTO convertCriteria);

	LuggageDTO getLuggageDTOById(Integer luggageId);







}





