package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.BaggageClaim;





public interface BaggageClaimDAO extends GenericDAO<BaggageClaim, Integer> {
  
	List<BaggageClaim> findAll();
	






}


