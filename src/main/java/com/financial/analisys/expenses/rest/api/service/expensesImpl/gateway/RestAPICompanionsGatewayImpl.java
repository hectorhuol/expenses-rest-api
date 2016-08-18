package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.api.domain.Companion;
import com.financial.analisys.expenses.api.gateways.CompanionsGateway;
import com.financial.analisys.expenses.rest.api.domain.CompanionBO;
import com.financial.analisys.expenses.rest.api.exceptions.NoDataFoundException;
import com.financial.analisys.expenses.rest.api.repository.CompanionRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPICompanionsGatewayImpl implements CompanionsGateway {

	private CompanionRepository companionRepository;

	public RestAPICompanionsGatewayImpl(CompanionRepository companionRepository) {
		this.companionRepository = companionRepository;
	}

	@Override
	public Companion createCompanion(Companion companion) {
		CompanionBO companionBO = companionRepository.save(BOUtils
				.transformObject(companion, CompanionBO.class));
		if (isObjectNull(companionBO)) {
			companion.setCompanionId(companionBO.getCompanionId());
			return companion;
		}
		throw new NoDataFoundException("No data found");
	}

	@Override
	public void updateCompanion(Companion companion) {
		companionRepository.save(BOUtils.transformObject(companion,
				CompanionBO.class));
	}

	@Override
	public void deleteCompanion(Companion companion) {
		companionRepository.delete(BOUtils.transformObject(companion,
				CompanionBO.class));
	}

	@Override
	public Companion getCompanion(Companion companion) {
		CompanionBO companionBO = companionRepository.findOne(companion
				.getCompanionId());
		if (isObjectNull(companionBO))
			return BOUtils.transformObject(companionBO, Companion.class);
		throw new NoDataFoundException("No data found");
	}

	@Override
	public List<Companion> getAllCompanions() {
		List<CompanionBO> list = companionRepository.findAll();
		if (isObjectNull(list))
			return BOUtils.transformObjectList(list, Companion.class);
		throw new NoDataFoundException("No data found");
	}

	private boolean isObjectNull(Object object) {
		return object != null;
	}
}