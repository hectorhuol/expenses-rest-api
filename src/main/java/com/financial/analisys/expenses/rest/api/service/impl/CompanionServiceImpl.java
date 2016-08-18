package com.financial.analisys.expenses.rest.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.api.domain.Companion;
import com.financial.analisys.expenses.rest.api.domain.CompanionBO;
import com.financial.analisys.expenses.rest.api.service.CompanionService;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.ExpensesAPIFacade;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

@Service
public class CompanionServiceImpl implements CompanionService {

	@Autowired
	private ExpensesAPIFacade expensesAPIFacade;

	@Override
	public CompanionBO createCompanion(CompanionBO companionBO) {
		Companion companion = expensesAPIFacade.getCompanionsManager()
				.createCompanion(
						BOUtils.transformObject(companionBO, Companion.class));
		companionBO.setCompanionId(companion.getCompanionId());
		return companionBO;
	}

	@Override
	public void updateCompanion(CompanionBO companionBO) {
		expensesAPIFacade.getCompanionsManager().updateCompanion(
				BOUtils.transformObject(companionBO, Companion.class));
	}

	@Override
	public void deleteCompanion(String id) {
		Companion companion = new Companion();
		companion.setCompanionId(id);
		expensesAPIFacade.getCompanionsManager().deleteCompanion(companion);
	}

	@Override
	public CompanionBO getCompanion(String id) {
		Companion companion = new Companion();
		companion.setCompanionId(id);
		companion = expensesAPIFacade.getCompanionsManager().getCompanion(
				companion);
		return BOUtils.transformObject(companion, CompanionBO.class);
	}

	@Override
	public List<CompanionBO> getAllCompanions() {
		List<Companion> companions = expensesAPIFacade.getCompanionsManager()
				.getAllCompanions();
		return BOUtils.transformObjectList(companions, CompanionBO.class);
	}

}
