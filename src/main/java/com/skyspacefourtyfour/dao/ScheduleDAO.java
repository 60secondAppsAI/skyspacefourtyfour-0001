package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.Schedule;





public interface ScheduleDAO extends GenericDAO<Schedule, Integer> {
  
	List<Schedule> findAll();
	






}


