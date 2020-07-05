package com.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.languages.models.Language;


@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	List<Language> findAll();
	
	List<Language> findByCreator(String search);
	
	void deleteById(Long id);
	
	Long deleteByCreator(String search);
}
