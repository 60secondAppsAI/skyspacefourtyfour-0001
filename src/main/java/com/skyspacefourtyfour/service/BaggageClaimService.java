package com.skyspacefourtyfour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefourtyfour.domain.BaggageClaim;
import com.skyspacefourtyfour.dto.BaggageClaimDTO;
import com.skyspacefourtyfour.dto.BaggageClaimSearchDTO;
import com.skyspacefourtyfour.dto.BaggageClaimPageDTO;
import com.skyspacefourtyfour.dto.BaggageClaimConvertCriteriaDTO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface BaggageClaimService extends GenericService<BaggageClaim, Integer> {

	List<BaggageClaim> findAll();

	ResultDTO addBaggageClaim(BaggageClaimDTO baggageClaimDTO, RequestDTO requestDTO);

	ResultDTO updateBaggageClaim(BaggageClaimDTO baggageClaimDTO, RequestDTO requestDTO);

    Page<BaggageClaim> getAllBaggageClaims(Pageable pageable);

    Page<BaggageClaim> getAllBaggageClaims(Specification<BaggageClaim> spec, Pageable pageable);

	ResponseEntity<BaggageClaimPageDTO> getBaggageClaims(BaggageClaimSearchDTO baggageClaimSearchDTO);
	
	List<BaggageClaimDTO> convertBaggageClaimsToBaggageClaimDTOs(List<BaggageClaim> baggageClaims, BaggageClaimConvertCriteriaDTO convertCriteria);

	BaggageClaimDTO getBaggageClaimDTOById(Integer baggageClaimId);







}





