package com.ecommerce.oms.order.dao;

import com.ecommerce.oms.order.model.Vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends MongoRepository<Vendor,Long> {
}
