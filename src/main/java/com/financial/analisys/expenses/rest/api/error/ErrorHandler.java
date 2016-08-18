package com.financial.analisys.expenses.rest.api.error;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.financial.analisys.expenses.api.exceptions.CardException;
import com.financial.analisys.expenses.api.exceptions.CategoryException;
import com.financial.analisys.expenses.api.exceptions.CompanionException;
import com.financial.analisys.expenses.api.exceptions.ExpenseException;
import com.financial.analisys.expenses.api.exceptions.TechnicalException;
import com.financial.analisys.expenses.api.exceptions.UserException;
import com.financial.analisys.expenses.rest.api.error.model.ErrorModel;
import com.financial.analisys.expenses.rest.api.exceptions.NoDataFoundException;

@ControllerAdvice
public class ErrorHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorModel> handleException(
			HttpServletRequest req, TechnicalException e) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return getErrorModel(req, e, status);
	}

	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorModel> handleRuntimeException(
			HttpServletRequest req, TechnicalException e) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		return getErrorModel(req, e, status);
	}

	@ExceptionHandler(NoDataFoundException.class)
	public ResponseEntity<ErrorModel> handleNoDataFoundException(
			HttpServletRequest req, NoDataFoundException e) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		return getErrorModel(req, e, status);
	}

	@ExceptionHandler(CardException.class)
	public ResponseEntity<ErrorModel> handleCardException(
			HttpServletRequest req, CardException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return getErrorModel(req, e, status);

	}

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<ErrorModel> handleCategoryException(
			HttpServletRequest req, CategoryException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return getErrorModel(req, e, status);
	}

	@ExceptionHandler(CompanionException.class)
	public ResponseEntity<ErrorModel> handleCompanionException(
			HttpServletRequest req, CompanionException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return getErrorModel(req, e, status);
	}

	@ExceptionHandler(ExpenseException.class)
	public ResponseEntity<ErrorModel> handleExpenseException(
			HttpServletRequest req, ExpenseException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return getErrorModel(req, e, status);
	}

	@ExceptionHandler(UserException.class)
	public ResponseEntity<ErrorModel> handleUserException(
			HttpServletRequest req, UserException e) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		return getErrorModel(req, e, status);
	}

	private <T extends RuntimeException> ResponseEntity<ErrorModel> getErrorModel(
			HttpServletRequest req, T e, HttpStatus status) {
		ErrorModel error = new ErrorModel();
		error.setStatusCode(status.value());
		error.setStatusPhrase(status.getReasonPhrase());
		error.setMessage(e.getMessage());
		error.setErrorURI(req.getRequestURI());
		return new ResponseEntity<ErrorModel>(error, status);
	}

}
