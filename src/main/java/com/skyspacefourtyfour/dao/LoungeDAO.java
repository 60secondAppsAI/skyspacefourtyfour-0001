package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.Lounge;





public interface LoungeDAO extends GenericDAO<Lounge, Integer> {
  
	List<Lounge> findAll();
	






}


