package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.CheckIn;





public interface CheckInDAO extends GenericDAO<CheckIn, Integer> {
  
	List<CheckIn> findAll();
	






}


