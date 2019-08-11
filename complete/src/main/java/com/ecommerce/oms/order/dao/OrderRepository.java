package com.ecommerce.oms.order.dao;

import com.ecommerce.oms.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,Long> {
}
