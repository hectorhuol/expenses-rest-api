package com.financial.analisys.expenses.rest.api.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.financial.analisys.expenses.api.domain.User;
import com.financial.analisys.expenses.rest.api.domain.UserBO;
import com.financial.analisys.expenses.rest.api.service.UserService;
import com.financial.analisys.expenses.rest.api.service.expensesImpl.ExpensesAPIFacade;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private ExpensesAPIFacade expensesAPIFacade;

	@Override
	public UserBO createUser(UserBO userBO) {
		User user = BOUtils.transformObject(userBO, User.class);
		user = expensesAPIFacade.getUsersManager().createUser(user);
		userBO.setUserId(user.getUserId());
		return userBO;
	}

	@Override
	public void updateUser(UserBO userBO) {
		expensesAPIFacade.getUsersManager().updateUser(
				BOUtils.transformObject(userBO, User.class));
	}

	@Override
	public void deleteUser(String id) {
		User user = new User();
		user.setUserId(id);
		expensesAPIFacade.getUsersManager().deleteUser(user);
	}

	@Override
	public UserBO getUser(String id) {
		User user = new User();
		user.setUserId(id);
		user = expensesAPIFacade.getUsersManager().getUser(user);
		return BOUtils.transformObject(user, UserBO.class);
	}

	@Override
	public List<UserBO> getAllUsers() {
		List<User> users = expensesAPIFacade.getUsersManager().getAllUsers();
		return BOUtils.transformObjectList(users, UserBO.class);
	}

}
