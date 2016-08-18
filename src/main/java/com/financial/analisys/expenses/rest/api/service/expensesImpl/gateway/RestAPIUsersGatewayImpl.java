package com.financial.analisys.expenses.rest.api.service.expensesImpl.gateway;

import java.util.List;

import com.financial.analisys.expenses.api.domain.User;
import com.financial.analisys.expenses.api.gateways.UsersGateway;
import com.financial.analisys.expenses.rest.api.domain.UserBO;
import com.financial.analisys.expenses.rest.api.exceptions.NoDataFoundException;
import com.financial.analisys.expenses.rest.api.repository.UserRepository;
import com.financial.analisys.expenses.rest.api.utils.BOUtils;

public class RestAPIUsersGatewayImpl implements UsersGateway {

	private UserRepository userRepository;

	public RestAPIUsersGatewayImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public User createUser(User user) {
		UserBO userBO = BOUtils.transformObject(user, UserBO.class);
		userBO = userRepository.save(userBO);
		if (isObjectNull(userBO)) {
			user.setUserId(userBO.getUserId());
			return user;
		}
		throw new NoDataFoundException("No data found");
	}

	@Override
	public void updateUser(User user) {
		userRepository.save(BOUtils.transformObject(user, UserBO.class));
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(BOUtils.transformObject(user, UserBO.class));
	}

	@Override
	public User getUser(User user) {
		UserBO userBO = userRepository.findOne(user.getUserId());
		if (isObjectNull(userBO))
			return BOUtils.transformObject(userBO, User.class);
		throw new NoDataFoundException("No data found");
	}

	@Override
	public List<User> getAllUsers() {
		List<UserBO> list = userRepository.findAll();
		if (isObjectNull(list))
			return BOUtils.transformObjectList(list, User.class);
		throw new NoDataFoundException("No data found");
	}

	private boolean isObjectNull(Object object) {
		return object != null;
	}
}