package com.financial.analisys.expenses.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.financial.analisys.expenses.rest.api.domain.CompanionBO;
import com.financial.analisys.expenses.rest.api.service.CompanionService;

@RestController
public class CompanionController {

	@Autowired
	private CompanionService companionService;

	@RequestMapping(path = "/companion", method = RequestMethod.POST)
	public CompanionBO createCompanion(@RequestBody CompanionBO companionBO) {
		return companionService.createCompanion(companionBO);
	}

	@RequestMapping(path = "/companion", method = RequestMethod.PUT)
	public void updateCompanion(@RequestBody CompanionBO companionBO) {
		companionService.updateCompanion(companionBO);
	}

	@RequestMapping(path = "/companion/{id}", method = RequestMethod.DELETE)
	public void deleteCompanion(@PathVariable String id) {
		companionService.deleteCompanion(id);
	}

	@RequestMapping(path = "/companion/{id}", method = RequestMethod.GET)
	public CompanionBO getCompanion(@PathVariable String id) {
		return companionService.getCompanion(id);
	}

	@RequestMapping(path = "/companion", method = RequestMethod.GET)
	public List<CompanionBO> getAllCompanions() {
		return companionService.getAllCompanions();
	}

}
