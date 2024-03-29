package com.ecommerce.oms.order.dao;

import com.ecommerce.oms.order.model.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account, Long> {
}
