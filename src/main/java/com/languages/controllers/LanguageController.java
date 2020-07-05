package com.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.languages.models.Language;
import com.languages.services.LanguageService;

@Controller
public class LanguageController {
	private final LanguageService service;
	
	public LanguageController(LanguageService service) {
		this.service = service;
	}
	
	@RequestMapping("/languages")
	public String index(@ModelAttribute("language") Language language, Model model) {
		List<Language> languages = service.allLanguages();
		model.addAttribute("languages", languages);
		return "Index";
	}
	
	@RequestMapping(value="/languages", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("language") Language language, Model model, BindingResult result) {
		
		if (result.hasErrors()) {
			return "/languages";
		}
		
		else {
			service.createLanguage(language);
			return "redirect:/languages";
		}
		
	}
	
	@GetMapping("/languages/{id}")
	public String show(@PathVariable("id") Long id, Model model) {
		Language language = service.findLanguage(id);
		model.addAttribute("language", language);
		return "Show";
	}
	
	@RequestMapping("/languages/{id}/edit")
	public String edit(@PathVariable("id") Long id, Model model) {
		Language language = service.findLanguage(id);
		model.addAttribute("language", language);
		return "Edit";
	}
	
	@RequestMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Language language, BindingResult result) {
		
		if (result.hasErrors()) {
			return "Edit";
		}
		
		else {
			service.updateLanguage(language.getId(), language.getName(), language.getCreator(), language.getVersion());
			return "redirect:/languages";
		}
	}
	
	@RequestMapping("/languages/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		service.deleteLanguage(id);
		return "redirect:/languages";
	}
}
