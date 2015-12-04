package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.PlanFormation;


public interface PlanFormationDAO extends CrudRepository<PlanFormation, Long> {
	
}
