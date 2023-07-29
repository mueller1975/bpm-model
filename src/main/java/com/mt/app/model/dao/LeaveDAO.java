package com.mt.app.model.dao;

import org.springframework.data.repository.CrudRepository;

import com.mt.app.model.entity.Leave;

public interface LeaveDAO extends CrudRepository<Leave,Integer> {
    
}
