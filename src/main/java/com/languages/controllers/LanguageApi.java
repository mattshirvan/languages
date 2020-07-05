package com.languages.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.languages.models.Language;
import com.languages.services.LanguageService;

@RestController
public class LanguageApi {
	private final LanguageService service;
	
	public LanguageApi(LanguageService service) {
		this.service = service;
	}
	
	@GetMapping("/api/languages")
	public List<Language> index() {
		return service.allLanguages();
	}
	
	@PostMapping("/api/languages")
	public Language create(@RequestParam("name") String name, @RequestParam("creator") String creator, @RequestParam("version") String version) {
		Language language = new Language(name, creator, version);
		return service.createLanguage(language);
	}
	
	@GetMapping("/api/languages/{id}")
	public Language show(@PathVariable("id") Long id) {
		Language language = service.findLanguage(id);
		return language;
	}
	
	@PutMapping("/api/languages/{id}")
	public Language update(@PathVariable("id") Long id, @RequestParam("name") String name, @RequestParam("creator") String creator, @RequestParam("version") String version) {
		Language language = service.updateLanguage(id, name, creator, version);
		return language;
		
	}
	
	@DeleteMapping("/api/languages/{id}/delete")
	public void delete(@PathVariable("id") Long id) {
		service.deleteLanguage(id);		
	}
}
