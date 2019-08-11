package com.ecommerce.oms.order.service;

import com.ecommerce.oms.order.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface OrderService {
    Map<Long, String> createOrder(List<Order> orderDetails, String accountId);
    String modifyOrder(Order orderDetails, Long orderId);
    String deleteOrder(Long orderId);
}
