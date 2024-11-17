package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.Staff;





public interface StaffDAO extends GenericDAO<Staff, Integer> {
  
	List<Staff> findAll();
	






}


