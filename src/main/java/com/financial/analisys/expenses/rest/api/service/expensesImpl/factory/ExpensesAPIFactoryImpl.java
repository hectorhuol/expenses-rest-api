package com.financial.analisys.expenses.rest.api.service.expensesImpl.factory;

import com.financial.analisys.expenses.api.factory.GatewayType;
import com.financial.analisys.expenses.api.factory.impl.FinancialsAnalisysFactoryImpl;
import com.financial.analisys.expenses.api.gateways.CardsGateway;
import com.financial.analisys.expenses.api.gateways.CategoriesGateway;
import com.financial.analisys.expenses.api.gateways.CompanionsGateway;
import com.financial.analisys.expenses.api.gateways.ExpensesGateway;
import com.financial.analisys.expenses.api.gateways.ExpensesReportsGateway;
import com.financial.analisys.expenses.api.gateways.UsersGateway;
import com.financial.analisys.expenses.rest.api.repository.CardRepository;
import com.financial.analisys.expenses.rest.api.repository.CategoryRepository;
import com.financial.analisys.expenses.rest.api.repository.CompanionRepository;
import com.financial.analisys.expenses.rest.api.repository.ExpenseRepository;
import com.financial.analisys.expenses.rest.api.repository.UserRepository;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway.RestAPICardsGatewayImpl;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway.RestAPICategoriesGatewayImpl;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway.RestAPICompanionsGatewayImpl;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway.RestAPIExpensesGatewayImpl;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway.RestAPIReportsExpensesGatewayImpl;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway.RestAPIUsersGatewayImpl;

public class ExpensesAPIFactoryImpl extends FinancialsAnalisysFactoryImpl {

	private UserRepository userRepository;
	private ExpenseRepository expenseRepository;
	private CardRepository cardRepository;
	private CategoryRepository categoryRepository;
	private CompanionRepository companionRepository;

	public ExpensesAPIFactoryImpl(UserRepository userRepository,
			ExpenseRepository expenseRepository, CardRepository cardRepository,
			CategoryRepository categoryRepository,
			CompanionRepository companionRepository) {
		this.userRepository = userRepository;
		this.cardRepository = cardRepository;
		this.expenseRepository = expenseRepository;
		this.categoryRepository = categoryRepository;
		this.companionRepository = companionRepository;
	}

	@Override
	public CardsGateway createCardsGateway(GatewayType gatewayType) {
		switch (gatewayType) {
		case CUSTOM:
			return new RestAPICardsGatewayImpl(cardRepository);
		default:
			return null;
		}
	}

	@Override
	public CategoriesGateway createCategoriesGateway(GatewayType gatewayType) {
		switch (gatewayType) {
		case CUSTOM:
			return new RestAPICategoriesGatewayImpl(categoryRepository);
		default:
			return null;
		}
	}

	@Override
	public CompanionsGateway createCompanionsGateway(GatewayType gatewayType) {
		switch (gatewayType) {
		case CUSTOM:
			return new RestAPICompanionsGatewayImpl(companionRepository);
		default:
			return null;
		}
	}

	@Override
	public ExpensesGateway createExpensesGateway(GatewayType gatewayType) {
		switch (gatewayType) {
		case CUSTOM:
			return new RestAPIExpensesGatewayImpl(expenseRepository);
		default:
			return null;
		}
	}

	@Override
	public ExpensesReportsGateway createExpensesReportsGateway(
			GatewayType gatewayType) {
		switch (gatewayType) {
		case CUSTOM:
			return new RestAPIReportsExpensesGatewayImpl(expenseRepository);
		default:
			return null;
		}
	}

	@Override
	public UsersGateway createUsersGateway(GatewayType gatewayType) {
		switch (gatewayType) {
		case CUSTOM:
			return new RestAPIUsersGatewayImpl(userRepository);
		default:
			return null;
		}
	}

}