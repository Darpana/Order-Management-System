package com.ecommerce.oms.order.dao;

import com.ecommerce.oms.order.model.Item;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends MongoRepository<Item,Long> {
    @Override
    Optional<Item> findById(Long aLong);
}
