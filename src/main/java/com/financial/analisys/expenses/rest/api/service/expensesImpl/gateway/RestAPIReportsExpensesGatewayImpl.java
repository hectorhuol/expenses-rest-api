package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.financial.analisys.expenses.api.domain.Category;
import com.financial.analisys.expenses.api.domain.Companion;
import com.financial.analisys.expenses.api.domain.Expense;
import com.financial.analisys.expenses.api.domain.User;
import com.financial.analisys.expenses.api.gateways.ExpensesReportsGateway;
import com.financial.analisys.expenses.api.utils.FinancialUtils;
import com.financial.analisys.expenses.rest.api.domain.CategoryBO;
import com.financial.analisys.expenses.rest.api.domain.CompanionBO;
import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;
import com.financial.analisys.expenses.rest.api.domain.UserBO;
import com.financial.analisys.expenses.rest.api.exceptions.NoDataFoundException;
import com.financial.analisys.expenses.rest.api.repository.ExpenseRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPIReportsExpensesGatewayImpl implements
		ExpensesReportsGateway {

	private ExpenseRepository expenseRepository;

	public RestAPIReportsExpensesGatewayImpl(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	@Override
	public List<Expense> getExpensesByCategoryByUser(Category category,
			User user) {
		CategoryBO categoryBO = BOUtils.transformObject(category,
				CategoryBO.class);
		UserBO userBO = BOUtils.transformObject(user, UserBO.class);
		List<ExpenseBO> list = expenseRepository.findByUserAndCategory(userBO,
				categoryBO);
		if (isObjectNull(list))
			return BOUtils.transformObjectList(list, Expense.class);
		throw new NoDataFoundException("No data found");
	}

	@Override
	public List<Expense> getExpensesByCityByUser(String cityName, User user) {
		UserBO userBO = BOUtils.transformObject(user, UserBO.class);
		List<ExpenseBO> list = expenseRepository.findByUserAndCity(userBO,
				cityName);
		if (isObjectNull(list))
			return BOUtils.transformObjectList(list, Expense.class);
		throw new NoDataFoundException("No data found");
	}

	@Override
	public List<Expense> getExpensesByCompanionsByUser(
			List<Companion> companions, User user) {
		List<ExpenseBO> list = getValuesList(user);
		list = findByCompanions(companions, list);
		return BOUtils.transformObjectList(list, Expense.class);
	}

	private List<ExpenseBO> findByCompanions(List<Companion> companions,
			List<ExpenseBO> list) {
		List<ExpenseBO> values = new ArrayList<ExpenseBO>();
		for (ExpenseBO expenseBO : list) {
			if (hasSomeCompanion(expenseBO.getCompanions(), companions))
				values.add(expenseBO);
		}
		return values;
	}

	private boolean hasSomeCompanion(List<CompanionBO> expenseCompanions,
			List<Companion> companions) {
		List<CompanionBO> companionsBO = BOUtils.transformObjectList(
				companions, CompanionBO.class);
		for (CompanionBO companionBO : expenseCompanions)
			if (companionsBO.contains(companionBO))
				return true;
		return false;
	}

	@Override
	public List<Expense> getExpensesByMonthByUser(LocalDate month, User user) {
		List<ExpenseBO> list = getValuesList(user);
		list = findByMonth(month, list);
		return BOUtils.transformObjectList(list, Expense.class);
	}

	private List<ExpenseBO> findByMonth(LocalDate month, List<ExpenseBO> list) {
		List<ExpenseBO> values = new ArrayList<ExpenseBO>();
		for (ExpenseBO expenseBO : list) {
			if (isMonthEqual(month, expenseBO))
				values.add(expenseBO);
		}
		return values;
	}

	private boolean isMonthEqual(LocalDate month, ExpenseBO expenseBO) {
		return FinancialUtils.getLocalDateTime(expenseBO.getDateAndHour())
				.getMonth().equals(month.getMonth());
	}

	@Override
	public List<Expense> getExpensesByDayByUser(LocalDate day, User user) {
		List<ExpenseBO> list = getValuesList(user);
		list = findByDay(day, list);
		return BOUtils.transformObjectList(list, Expense.class);
	}

	private List<ExpenseBO> findByDay(LocalDate day, List<ExpenseBO> list) {
		List<ExpenseBO> values = new ArrayList<ExpenseBO>();
		for (ExpenseBO expenseBO : list) {
			if (isDayEqual(day, expenseBO))
				values.add(expenseBO);
		}
		return values;
	}

	private boolean isDayEqual(LocalDate day, ExpenseBO expenseBO) {
		return FinancialUtils.getLocalDateTime(expenseBO.getDateAndHour())
				.toLocalDate().isEqual(day);
	}

	@Override
	public List<Expense> getExpensesBetweenDatesByUser(LocalDateTime startDate,
			LocalDateTime finishDate, User user) {
		List<ExpenseBO> list = getValuesList(user);
		list = findBetweenDates(startDate, finishDate, list);
		return BOUtils.transformObjectList(list, Expense.class);
	}

	private List<ExpenseBO> findBetweenDates(LocalDateTime startDate,
			LocalDateTime finishDate, List<ExpenseBO> list) {
		List<ExpenseBO> values = new ArrayList<ExpenseBO>();
		for (ExpenseBO expenseBO : list) {
			if (isDateBetweenStartAndFinishDates(startDate, finishDate,
					expenseBO))
				values.add(expenseBO);
		}
		return values;
	}

	private boolean isDateBetweenStartAndFinishDates(LocalDateTime startDate,
			LocalDateTime finishDate, ExpenseBO expenseBO) {
		return FinancialUtils.getLocalDateTime(expenseBO.getDateAndHour())
				.toLocalDate().isAfter(startDate.toLocalDate())
				&& FinancialUtils.getLocalDateTime(expenseBO.getDateAndHour())
						.toLocalDate().isBefore(finishDate.toLocalDate())
				|| FinancialUtils.getLocalDateTime(expenseBO.getDateAndHour())
						.toLocalDate().isEqual(startDate.toLocalDate())
				|| FinancialUtils.getLocalDateTime(expenseBO.getDateAndHour())
						.toLocalDate().isEqual(finishDate.toLocalDate());
	}

	private List<ExpenseBO> getValuesList(User user) {
		UserBO userBO = BOUtils.transformObject(user, UserBO.class);
		List<ExpenseBO> list = expenseRepository.findByUser(userBO);
		if (isObjectNull(list))
			return list;
		throw new NoDataFoundException("No data found");
	}

	private boolean isObjectNull(Object object) {
		return object != null;
	}
}