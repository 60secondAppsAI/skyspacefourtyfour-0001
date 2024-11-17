package com.skyspacefourtyfour.dao;

import java.util.List;

import com.skyspacefourtyfour.dao.GenericDAO;
import com.skyspacefourtyfour.domain.Ticket;





public interface TicketDAO extends GenericDAO<Ticket, Integer> {
  
	List<Ticket> findAll();
	






}


