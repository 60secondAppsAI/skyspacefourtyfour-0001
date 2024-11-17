package com.skyspacefourtyfour.service;

import com.skyspacefourtyfour.dao.GenericDAO;

public interface GenericService<T, ID> {

    abstract GenericDAO<T, ID> getDAO();

    T getById(Integer id) ;

}