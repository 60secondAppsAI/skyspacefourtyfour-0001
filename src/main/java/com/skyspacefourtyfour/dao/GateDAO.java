package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.Gate;





public interface GateDAO extends GenericDAO<Gate, Integer> {
  
	List<Gate> findAll();
	






}


