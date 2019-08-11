package com.ecommerce.oms.order.dao;

import com.ecommerce.oms.order.model.AccountAddressDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountAddressDetailsRepository extends MongoRepository<AccountAddressDetails, Long> {
}
