package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.Airport;





public interface AirportDAO extends GenericDAO<Airport, Integer> {
  
	List<Airport> findAll();
	






}


