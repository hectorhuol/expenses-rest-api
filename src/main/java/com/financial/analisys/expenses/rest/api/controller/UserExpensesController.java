package com.financial.analisys.expenses.rest.api.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;
import com.financial.analisys.expenses.rest.api.service.ExpenseService;

@RestController
public class UserExpensesController {

	@Autowired
	private ExpenseService expenseService;

	@RequestMapping(path = "/user/{userId}/expenses", method = RequestMethod.GET)
	public List<ExpenseBO> getAllUserExpenses(@PathVariable String userId) {
		return expenseService.getAllUserExpenses(userId);
	}

	@RequestMapping(path = "/user/{userId}/expenses", method = RequestMethod.GET, params = "categoryId")
	public List<ExpenseBO> getExpensesByCategoryByUser(
			@PathVariable String userId, @RequestParam String categoryId) {
		return expenseService.getExpensesByCategoryByUser(categoryId, userId);
	}

	@RequestMapping(path = "/user/{userId}/expenses", method = RequestMethod.GET, params = "cityName")
	public List<ExpenseBO> getExpensesByCityByUser(@PathVariable String userId,
			@RequestParam String cityName) {
		return expenseService.getExpensesByCityByUser(cityName, userId);
	}

	@RequestMapping(path = "/user/{userId}/expenses", method = RequestMethod.GET, params = "companionsIds")
	public List<ExpenseBO> getExpensesByCompanionsByUser(
			@PathVariable String userId, @RequestParam String[] companionsIds) {
		List<String> ids = null;
		if (companionsIds != null)
			ids = Arrays.asList(companionsIds);
		return expenseService.getExpensesByCompanionsByUser(ids, userId);
	}

	@RequestMapping(path = "/user/{userId}/expenses", method = RequestMethod.GET, params = "month")
	public List<ExpenseBO> getExpensesByMonthByUser(
			@PathVariable String userId, @RequestParam String month) {
		return expenseService.getExpensesByMonthByUser(month, userId);
	}

	@RequestMapping(path = "/user/{userId}/expenses", method = RequestMethod.GET, params = "day")
	public List<ExpenseBO> getExpensesByDayByUser(@PathVariable String userId,
			@RequestParam String day) {
		return expenseService.getExpensesByDayByUser(day, userId);
	}

	@RequestMapping(path = "/user/{userId}/expenses", method = RequestMethod.GET, params = {
			"startDate", "finishDate" })
	public List<ExpenseBO> getExpensesBetweenDatesByUser(
			@PathVariable String userId, @RequestParam String startDate,
			@RequestParam String finishDate) {
		return expenseService.getExpensesBetweenDatesByUser(startDate,
				finishDate, userId);
	}

}
