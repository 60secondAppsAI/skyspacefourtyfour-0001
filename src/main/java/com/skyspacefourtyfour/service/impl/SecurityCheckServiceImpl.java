package com.skyspacefourtyfour.service.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;



import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.service.GenericService;
import com.skyspacefourtyfour.service.impl.GenericServiceImpl;
import com.skyspacefourtyfour.dao.SecurityCheckDAO;
import com.skyspacefourtyfour.domain.SecurityCheck;
import com.skyspacefourtyfour.dto.SecurityCheckDTO;
import com.skyspacefourtyfour.dto.SecurityCheckSearchDTO;
import com.skyspacefourtyfour.dto.SecurityCheckPageDTO;
import com.skyspacefourtyfour.dto.SecurityCheckConvertCriteriaDTO;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import com.skyspacefourtyfour.service.SecurityCheckService;
import com.skyspacefourtyfour.util.ControllerUtils;





@Service
public class SecurityCheckServiceImpl extends GenericServiceImpl<SecurityCheck, Integer> implements SecurityCheckService {

    private final static Logger logger = LoggerFactory.getLogger(SecurityCheckServiceImpl.class);

	@Autowired
	SecurityCheckDAO securityCheckDao;

	


	@Override
	public GenericDAO<SecurityCheck, Integer> getDAO() {
		return (GenericDAO<SecurityCheck, Integer>) securityCheckDao;
	}
	
	public List<SecurityCheck> findAll () {
		List<SecurityCheck> securityChecks = securityCheckDao.findAll();
		
		return securityChecks;	
		
	}

	public ResultDTO addSecurityCheck(SecurityCheckDTO securityCheckDTO, RequestDTO requestDTO) {

		SecurityCheck securityCheck = new SecurityCheck();

		securityCheck.setSecurityCheckId(securityCheckDTO.getSecurityCheckId());


		securityCheck.setCheckStatus(securityCheckDTO.getCheckStatus());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		securityCheck = securityCheckDao.save(securityCheck);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<SecurityCheck> getAllSecurityChecks(Pageable pageable) {
		return securityCheckDao.findAll(pageable);
	}

	public Page<SecurityCheck> getAllSecurityChecks(Specification<SecurityCheck> spec, Pageable pageable) {
		return securityCheckDao.findAll(spec, pageable);
	}

	public ResponseEntity<SecurityCheckPageDTO> getSecurityChecks(SecurityCheckSearchDTO securityCheckSearchDTO) {
	
			Integer securityCheckId = securityCheckSearchDTO.getSecurityCheckId(); 
 			String checkStatus = securityCheckSearchDTO.getCheckStatus(); 
 			String sortBy = securityCheckSearchDTO.getSortBy();
			String sortOrder = securityCheckSearchDTO.getSortOrder();
			String searchQuery = securityCheckSearchDTO.getSearchQuery();
			Integer page = securityCheckSearchDTO.getPage();
			Integer size = securityCheckSearchDTO.getSize();

	        Specification<SecurityCheck> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, securityCheckId, "securityCheckId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, checkStatus, "checkStatus"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("checkStatus")), "%" + searchQuery.toLowerCase() + "%") 
		));}
		
		Sort sort = Sort.unsorted();
		if (sortBy != null && !sortBy.isEmpty() && sortOrder != null && !sortOrder.isEmpty()) {
			if (sortOrder.equalsIgnoreCase("asc")) {
				sort = Sort.by(sortBy).ascending();
			} else if (sortOrder.equalsIgnoreCase("desc")) {
				sort = Sort.by(sortBy).descending();
			}
		}
		Pageable pageable = PageRequest.of(page, size, sort);

		Page<SecurityCheck> securityChecks = this.getAllSecurityChecks(spec, pageable);
		
		//System.out.println(String.valueOf(securityChecks.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(securityChecks.getTotalPages()));
		
		List<SecurityCheck> securityChecksList = securityChecks.getContent();
		
		SecurityCheckConvertCriteriaDTO convertCriteria = new SecurityCheckConvertCriteriaDTO();
		List<SecurityCheckDTO> securityCheckDTOs = this.convertSecurityChecksToSecurityCheckDTOs(securityChecksList,convertCriteria);
		
		SecurityCheckPageDTO securityCheckPageDTO = new SecurityCheckPageDTO();
		securityCheckPageDTO.setSecurityChecks(securityCheckDTOs);
		securityCheckPageDTO.setTotalElements(securityChecks.getTotalElements());
		return ResponseEntity.ok(securityCheckPageDTO);
	}

	public List<SecurityCheckDTO> convertSecurityChecksToSecurityCheckDTOs(List<SecurityCheck> securityChecks, SecurityCheckConvertCriteriaDTO convertCriteria) {
		
		List<SecurityCheckDTO> securityCheckDTOs = new ArrayList<SecurityCheckDTO>();
		
		for (SecurityCheck securityCheck : securityChecks) {
			securityCheckDTOs.add(convertSecurityCheckToSecurityCheckDTO(securityCheck,convertCriteria));
		}
		
		return securityCheckDTOs;

	}
	
	public SecurityCheckDTO convertSecurityCheckToSecurityCheckDTO(SecurityCheck securityCheck, SecurityCheckConvertCriteriaDTO convertCriteria) {
		
		SecurityCheckDTO securityCheckDTO = new SecurityCheckDTO();
		
		securityCheckDTO.setSecurityCheckId(securityCheck.getSecurityCheckId());

	
		securityCheckDTO.setCheckStatus(securityCheck.getCheckStatus());

	

		
		return securityCheckDTO;
	}

	public ResultDTO updateSecurityCheck(SecurityCheckDTO securityCheckDTO, RequestDTO requestDTO) {
		
		SecurityCheck securityCheck = securityCheckDao.getById(securityCheckDTO.getSecurityCheckId());

		securityCheck.setSecurityCheckId(ControllerUtils.setValue(securityCheck.getSecurityCheckId(), securityCheckDTO.getSecurityCheckId()));

		securityCheck.setCheckStatus(ControllerUtils.setValue(securityCheck.getCheckStatus(), securityCheckDTO.getCheckStatus()));



        securityCheck = securityCheckDao.save(securityCheck);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public SecurityCheckDTO getSecurityCheckDTOById(Integer securityCheckId) {
	
		SecurityCheck securityCheck = securityCheckDao.getById(securityCheckId);
			
		
		SecurityCheckConvertCriteriaDTO convertCriteria = new SecurityCheckConvertCriteriaDTO();
		return(this.convertSecurityCheckToSecurityCheckDTO(securityCheck,convertCriteria));
	}







}
