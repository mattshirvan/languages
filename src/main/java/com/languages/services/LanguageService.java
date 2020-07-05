package com.languages.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.languages.models.Language;
import com.languages.repositories.LanguageRepository;

@Service
public class LanguageService {
	private final LanguageRepository repository;
	
	public LanguageService(LanguageRepository repository) {
		this.repository = repository;
	}
	
	public List<Language> allLanguages() {
		return repository.findAll();
	}
	
	public Language createLanguage(Language l) {
		return repository.save(l);
	}
	
	public Language findLanguage(Long id) {
		Optional<Language> optionalLanguage = repository.findById(id);
		
		if (optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		
		else {
			return null;
		}
	}
	
	public Language updateLanguage(Long id, String name, String creator, String version) {
		Optional<Language> optionalLanguage = repository.findById(id);
		
		if (optionalLanguage.isPresent()) {
			Language language = optionalLanguage.get();
			language.setName(name);
			language.setCreator(creator);
			language.setVersion(version);
			return repository.save(language);
		}
		return null;
	}
	
	public void deleteLanguage(Long id) {
		Optional<Language> optionalLanguage = repository.findById(id);
		
		if (optionalLanguage.isPresent()) {
			repository.deleteById(id);
		}
		
		else {
			System.out.println("Not found");
		}
	}
}
