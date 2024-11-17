package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.Fleet;





public interface FleetDAO extends GenericDAO<Fleet, Integer> {
  
	List<Fleet> findAll();
	






}


