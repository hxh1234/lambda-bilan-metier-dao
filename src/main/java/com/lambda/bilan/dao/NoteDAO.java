package com.lambda.bilan.dao;

import org.springframework.data.repository.CrudRepository;

import com.lambda.bilan.entities.Note;

public interface NoteDAO extends CrudRepository<Note, Long> {
		
}
