package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lambda.bilan.entities.ManagerRH;
import com.lambda.bilan.entities.Utilisateur;


public interface ManagerRHDAO extends CrudRepository<ManagerRH, Long> {
	
}
