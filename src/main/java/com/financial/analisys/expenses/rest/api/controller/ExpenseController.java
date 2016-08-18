package com.financial.analisys.expenses.rest.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.financial.analisys.expenses.rest.api.domain.ExpenseBO;
import com.financial.analisys.expenses.rest.api.service.ExpenseService;

@RestController
public class ExpenseController {

	@Autowired
	private ExpenseService expenseService;

	@RequestMapping(path = "/expense", method = RequestMethod.POST)
	public ExpenseBO createExpense(@RequestBody ExpenseBO expenseBO) {
		return expenseService.createExpense(expenseBO);
	}

	@RequestMapping(path = "/expense", method = RequestMethod.PUT)
	public void updateExpense(@RequestBody ExpenseBO expenseBO) {
		expenseService.updateExpense(expenseBO);
	}

	@RequestMapping(path = "/expense/{id}", method = RequestMethod.DELETE)
	public void deleteExpense(@PathVariable String id) {
		expenseService.deleteExpense(id);
	}

	@RequestMapping(path = "/expense/{id}", method = RequestMethod.GET)
	public ExpenseBO getExpense(@PathVariable String id) {
		return expenseService.getExpense(id);
	}

	@RequestMapping(path = "/expense", method = RequestMethod.GET)
	public List<ExpenseBO> getAllExpenses() {
		return expenseService.getAllExpenses();
	}

}
