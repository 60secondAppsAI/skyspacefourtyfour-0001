package com.skyspacefourtyfour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefourtyfour.domain.Lounge;
import com.skyspacefourtyfour.dto.LoungeDTO;
import com.skyspacefourtyfour.dto.LoungeSearchDTO;
import com.skyspacefourtyfour.dto.LoungePageDTO;
import com.skyspacefourtyfour.dto.LoungeConvertCriteriaDTO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface LoungeService extends GenericService<Lounge, Integer> {

	List<Lounge> findAll();

	ResultDTO addLounge(LoungeDTO loungeDTO, RequestDTO requestDTO);

	ResultDTO updateLounge(LoungeDTO loungeDTO, RequestDTO requestDTO);

    Page<Lounge> getAllLounges(Pageable pageable);

    Page<Lounge> getAllLounges(Specification<Lounge> spec, Pageable pageable);

	ResponseEntity<LoungePageDTO> getLounges(LoungeSearchDTO loungeSearchDTO);
	
	List<LoungeDTO> convertLoungesToLoungeDTOs(List<Lounge> lounges, LoungeConvertCriteriaDTO convertCriteria);

	LoungeDTO getLoungeDTOById(Integer loungeId);







}





