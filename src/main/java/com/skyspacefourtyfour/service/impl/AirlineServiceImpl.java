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
import com.skyspacefourtyfour.dao.AirlineDAO;
import com.skyspacefourtyfour.domain.Airline;
import com.skyspacefourtyfour.dto.AirlineDTO;
import com.skyspacefourtyfour.dto.AirlineSearchDTO;
import com.skyspacefourtyfour.dto.AirlinePageDTO;
import com.skyspacefourtyfour.dto.AirlineConvertCriteriaDTO;
import com.skyspacefourtyfour.dto.common.RequestDTO;
import com.skyspacefourtyfour.dto.common.ResultDTO;
import com.skyspacefourtyfour.service.AirlineService;
import com.skyspacefourtyfour.util.ControllerUtils;





@Service
public class AirlineServiceImpl extends GenericServiceImpl<Airline, Integer> implements AirlineService {

    private final static Logger logger = LoggerFactory.getLogger(AirlineServiceImpl.class);

	@Autowired
	AirlineDAO airlineDao;

	


	@Override
	public GenericDAO<Airline, Integer> getDAO() {
		return (GenericDAO<Airline, Integer>) airlineDao;
	}
	
	public List<Airline> findAll () {
		List<Airline> airlines = airlineDao.findAll();
		
		return airlines;	
		
	}

	public ResultDTO addAirline(AirlineDTO airlineDTO, RequestDTO requestDTO) {

		Airline airline = new Airline();

		airline.setAirlineId(airlineDTO.getAirlineId());


		airline.setName(airlineDTO.getName());


		airline.setCountryCode(airlineDTO.getCountryCode());


		LocalDate localDate = LocalDate.now();
		ZoneId defaultZoneId = ZoneId.systemDefault();
		Date date = Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());

		airline = airlineDao.save(airline);
		
		ResultDTO result = new ResultDTO();
		return result;
	}
	
	public Page<Airline> getAllAirlines(Pageable pageable) {
		return airlineDao.findAll(pageable);
	}

	public Page<Airline> getAllAirlines(Specification<Airline> spec, Pageable pageable) {
		return airlineDao.findAll(spec, pageable);
	}

	public ResponseEntity<AirlinePageDTO> getAirlines(AirlineSearchDTO airlineSearchDTO) {
	
			Integer airlineId = airlineSearchDTO.getAirlineId(); 
 			String name = airlineSearchDTO.getName(); 
 			String countryCode = airlineSearchDTO.getCountryCode(); 
 			String sortBy = airlineSearchDTO.getSortBy();
			String sortOrder = airlineSearchDTO.getSortOrder();
			String searchQuery = airlineSearchDTO.getSearchQuery();
			Integer page = airlineSearchDTO.getPage();
			Integer size = airlineSearchDTO.getSize();

	        Specification<Airline> spec = Specification.where(null);

			spec = ControllerUtils.andIfNecessary(spec, airlineId, "airlineId"); 
			
			spec = ControllerUtils.andIfNecessary(spec, name, "name"); 
			
			spec = ControllerUtils.andIfNecessary(spec, countryCode, "countryCode"); 
			

		if (searchQuery != null && !searchQuery.isEmpty()) {
			spec = spec.and((root, query, cb) -> cb.or(

             cb.like(cb.lower(root.get("name")), "%" + searchQuery.toLowerCase() + "%") 
             , cb.like(cb.lower(root.get("countryCode")), "%" + searchQuery.toLowerCase() + "%") 
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

		Page<Airline> airlines = this.getAllAirlines(spec, pageable);
		
		//System.out.println(String.valueOf(airlines.getTotalElements()) + " total ${classNamelPlural}, viewing page X of " + String.valueOf(airlines.getTotalPages()));
		
		List<Airline> airlinesList = airlines.getContent();
		
		AirlineConvertCriteriaDTO convertCriteria = new AirlineConvertCriteriaDTO();
		List<AirlineDTO> airlineDTOs = this.convertAirlinesToAirlineDTOs(airlinesList,convertCriteria);
		
		AirlinePageDTO airlinePageDTO = new AirlinePageDTO();
		airlinePageDTO.setAirlines(airlineDTOs);
		airlinePageDTO.setTotalElements(airlines.getTotalElements());
		return ResponseEntity.ok(airlinePageDTO);
	}

	public List<AirlineDTO> convertAirlinesToAirlineDTOs(List<Airline> airlines, AirlineConvertCriteriaDTO convertCriteria) {
		
		List<AirlineDTO> airlineDTOs = new ArrayList<AirlineDTO>();
		
		for (Airline airline : airlines) {
			airlineDTOs.add(convertAirlineToAirlineDTO(airline,convertCriteria));
		}
		
		return airlineDTOs;

	}
	
	public AirlineDTO convertAirlineToAirlineDTO(Airline airline, AirlineConvertCriteriaDTO convertCriteria) {
		
		AirlineDTO airlineDTO = new AirlineDTO();
		
		airlineDTO.setAirlineId(airline.getAirlineId());

	
		airlineDTO.setName(airline.getName());

	
		airlineDTO.setCountryCode(airline.getCountryCode());

	

		
		return airlineDTO;
	}

	public ResultDTO updateAirline(AirlineDTO airlineDTO, RequestDTO requestDTO) {
		
		Airline airline = airlineDao.getById(airlineDTO.getAirlineId());

		airline.setAirlineId(ControllerUtils.setValue(airline.getAirlineId(), airlineDTO.getAirlineId()));

		airline.setName(ControllerUtils.setValue(airline.getName(), airlineDTO.getName()));

		airline.setCountryCode(ControllerUtils.setValue(airline.getCountryCode(), airlineDTO.getCountryCode()));



        airline = airlineDao.save(airline);
		
		ResultDTO result = new ResultDTO();
		return result;
	}

	public AirlineDTO getAirlineDTOById(Integer airlineId) {
	
		Airline airline = airlineDao.getById(airlineId);
			
		
		AirlineConvertCriteriaDTO convertCriteria = new AirlineConvertCriteriaDTO();
		return(this.convertAirlineToAirlineDTO(airline,convertCriteria));
	}







}
