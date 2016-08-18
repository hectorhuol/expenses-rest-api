package com.financial.analisys.expenses.rest.api.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.financial.analisys.expenses.rest.api.domain.UserBO;

@Repository
public interface UserRepository extends MongoRepository<UserBO, String> {

}
