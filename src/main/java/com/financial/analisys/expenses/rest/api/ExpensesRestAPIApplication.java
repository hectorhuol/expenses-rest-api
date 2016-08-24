package com.financial.analisys.expenses.rest.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExpensesRestAPIApplication 
{
	private ExpensesRestAPIApplication(){}
	
	public static void main(String[] args) {
		SpringApplication.run(ExpensesRestAPIApplication.class, args);
	}
}
