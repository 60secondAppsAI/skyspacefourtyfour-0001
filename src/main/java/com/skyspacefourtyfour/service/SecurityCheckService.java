package com.skyspacefourtyfour.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;

import com.skyspacefourtyfour.domain.SecurityCheck;
import com.skyspacefourtyfour.dto.SecurityCheckDTO;
import com.skyspacefourtyfour.dto.SecurityCheckSearchDTO;
import com.skyspacefourtyfour.dto.SecurityCheckPageDTO;
import com.skyspacefourtyfour.dto.SecurityCheckConvertCriteriaDTO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import java.util.List;
import java.util.Optional;





public interface SecurityCheckService extends GenericService<SecurityCheck, Integer> {

	List<SecurityCheck> findAll();

	ResultDTO addSecurityCheck(SecurityCheckDTO securityCheckDTO, RequestDTO requestDTO);

	ResultDTO updateSecurityCheck(SecurityCheckDTO securityCheckDTO, RequestDTO requestDTO);

    Page<SecurityCheck> getAllSecurityChecks(Pageable pageable);

    Page<SecurityCheck> getAllSecurityChecks(Specification<SecurityCheck> spec, Pageable pageable);

	ResponseEntity<SecurityCheckPageDTO> getSecurityChecks(SecurityCheckSearchDTO securityCheckSearchDTO);
	
	List<SecurityCheckDTO> convertSecurityChecksToSecurityCheckDTOs(List<SecurityCheck> securityChecks, SecurityCheckConvertCriteriaDTO convertCriteria);

	SecurityCheckDTO getSecurityCheckDTOById(Integer securityCheckId);







}





