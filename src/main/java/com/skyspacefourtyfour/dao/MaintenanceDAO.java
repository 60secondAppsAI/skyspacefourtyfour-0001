package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.Maintenance;





public interface MaintenanceDAO extends GenericDAO<Maintenance, Integer> {
  
	List<Maintenance> findAll();
	






}


