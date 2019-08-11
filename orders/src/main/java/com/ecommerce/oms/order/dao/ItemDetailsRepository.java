package com.ecommerce.oms.order.dao;

import com.ecommerce.oms.order.model.ItemDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemDetailsRepository extends MongoRepository<ItemDetails, Long> {
    @Override
    Optional<ItemDetails> findById(Long aLong);

    @Query("{ 'itemId' : ?0, 'unit' : ?0, 'unitValue' : ?0}")
    ItemDetails findByItemIdandUnitandUnitValue(Long itemId, String unit, Long unitValue);
}
