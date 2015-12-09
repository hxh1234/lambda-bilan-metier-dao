package com.lambda.bilan.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Collaborateur;
import com.lambda.bilan.entities.ManagerRH;


public interface ManagerRHDAO extends CrudRepository<ManagerRH, Long> {
	@Query("select c from Collaborateur c where c.managerRH.idUtilisateur=?1")
	List<Collaborateur> getAll(Long id) throws Exception;
}
