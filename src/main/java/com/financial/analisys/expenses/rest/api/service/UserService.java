package com.financial.analisys.expenses.rest.api.service;

import java.util.List;

import com.financial.analisys.expenses.rest.api.domain.UserBO;

public interface UserService {

	UserBO createUser(UserBO userBO);

	void updateUser(UserBO userBO);

	void deleteUser(String id);

	UserBO getUser(String id);

	List<UserBO> getAllUsers();

}
