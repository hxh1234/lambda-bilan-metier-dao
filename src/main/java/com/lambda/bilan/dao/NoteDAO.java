package com.lambda.bilan.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Intervention;
import com.lambda.bilan.entities.Note;

public interface NoteDAO extends CrudRepository<Note, Long> {
	
	public List<Note> findByIntervention(Intervention intervention)  throws Exception;
	
}
