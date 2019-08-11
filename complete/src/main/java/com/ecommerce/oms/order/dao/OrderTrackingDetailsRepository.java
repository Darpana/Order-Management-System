package com.ecommerce.oms.order.dao;

import com.ecommerce.oms.order.model.OrderTrackingDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderTrackingDetailsRepository extends MongoRepository<OrderTrackingDetails, Long> {
}
