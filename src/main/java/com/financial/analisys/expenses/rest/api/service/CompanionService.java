package com.financial.analisys.expenses.rest.api.service;

import java.util.List;

import com.financial.analisys.expenses.rest.api.domain.CompanionBO;

public interface CompanionService {

	CompanionBO createCompanion(CompanionBO companionBO);

	void updateCompanion(CompanionBO companionBO);

	void deleteCompanion(String id);

	CompanionBO getCompanion(String id);

	List<CompanionBO> getAllCompanions();

}
