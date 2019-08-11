package com.ecommerce.oms.order.service;

import com.ecommerce.oms.order.model.ItemDetails;
import com.ecommerce.oms.order.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface InventoryService {
    Map<Long, String> availabilityCheck(List<Order> orderDetails);
    boolean isItemAvailable(Order orderDetails);
}
