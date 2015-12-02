package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lambda.bilan.entities.Utilisateur;

@Repository
public interface UserDAO extends CrudRepository<Utilisateur, Long> {
}
