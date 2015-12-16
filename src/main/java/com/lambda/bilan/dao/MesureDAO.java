package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Mesure;

public interface MesureDAO extends CrudRepository<Mesure,Long> {

}
