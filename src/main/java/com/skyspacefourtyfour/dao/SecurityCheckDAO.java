package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.SecurityCheck;





public interface SecurityCheckDAO extends GenericDAO<SecurityCheck, Integer> {
  
	List<SecurityCheck> findAll();
	






}


