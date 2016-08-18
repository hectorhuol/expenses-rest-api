package com.financial.analisys.expenses.rest.api.service.expensesImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.api.factory.FinancialsAnalisysFactory;
import com.financial.analisys.expenses.api.factory.GatewayType;
import com.financial.analisys.expenses.api.factory.ValidatorType;
import com.financial.analisys.expenses.api.managers.CardsManager;
import com.financial.analisys.expenses.api.managers.CategoriesManager;
import com.financial.analisys.expenses.api.managers.CompanionsManager;
import com.financial.analisys.expenses.api.managers.ExpensesManager;
import com.financial.analisys.expenses.api.managers.UsersManager;
import com.financial.analisys.expenses.rest.api.repository.CardRepository;
import com.financial.analisys.expenses.rest.api.repository.CategoryRepository;
import com.financial.analisys.expenses.rest.api.repository.CompanionRepository;
import com.financial.analisys.expenses.rest.api.repository.ExpenseRepository;
import com.financial.analisys.expenses.rest.api.repository.UserRepository;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.factory.ExpensesAPIFactoryImpl;

@Service
public class ExpensesAPIFacade {

	private UsersManager usersManager;
	private CardsManager cardsManager;
	private CompanionsManager companionsManager;
	private CategoriesManager categoriesManager;
	private ExpensesManager expensesManager;
	private FinancialsAnalisysFactory financialsFactory;

	@Autowired
	public ExpensesAPIFacade(UserRepository userRepository,
			ExpenseRepository expenseRepository, CardRepository cardRepository,
			CategoryRepository categoryRepository,
			CompanionRepository companionRepository) {
		financialsFactory = new ExpensesAPIFactoryImpl(userRepository,
				expenseRepository, cardRepository, categoryRepository,
				companionRepository);
		usersManager = UsersManager.getNewUsersManager(
				financialsFactory.createUsersGateway(GatewayType.CUSTOM),
				financialsFactory.createUsersValidator(ValidatorType.DEFAULT));
		cardsManager = CardsManager.getNewCardsManager(
				financialsFactory.createCardsGateway(GatewayType.CUSTOM),
				financialsFactory.createCardsValidator(ValidatorType.DEFAULT));
		companionsManager = CompanionsManager.getNewCompanionsManager(
				financialsFactory.createCompanionsGateway(GatewayType.CUSTOM),
				financialsFactory
						.createCompanionsValidator(ValidatorType.DEFAULT));
		categoriesManager = CategoriesManager.getNewCategoriesManager(
				financialsFactory.createCategoriesGateway(GatewayType.CUSTOM),
				financialsFactory
						.createCategoriesValidator(ValidatorType.DEFAULT));
		expensesManager = ExpensesManager.getNewExpensesManager(
				financialsFactory.createExpensesGateway(GatewayType.CUSTOM),
				financialsFactory
						.createExpensesReportsGateway(GatewayType.CUSTOM),
				financialsFactory
						.createExpensesValidator(ValidatorType.DEFAULT));
	}

	public UsersManager getUsersManager() {
		return usersManager;
	}

	public CardsManager getCardsManager() {
		return cardsManager;
	}

	public ExpensesManager getExpensesManager() {
		return expensesManager;
	}

	public CompanionsManager getCompanionsManager() {
		return companionsManager;
	}

	public CategoriesManager getCategoriesManager() {
		return categoriesManager;
	}

}
