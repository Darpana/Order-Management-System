package com.ecommerce.oms.order.service;

import com.ecommerce.oms.order.dao.OrderRepository;
import com.ecommerce.oms.order.dao.OrderTrackingDetailsRepository;
import com.ecommerce.oms.order.model.Order;
import com.ecommerce.oms.order.model.OrderTrackingDetails;
import com.ecommerce.oms.order.utils.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    InventoryService inventoryService;

    @Autowired
    OrderTrackingDetailsRepository orderTrackingDetailsRepository;

    @Autowired
    OrderRepository orderRepository;

    /*
    Race condition- If multiple requests comes by multiple threads, an item read and write could lead to an inconsistent state resulting in an incorrect count of an item
    Solution- Synchronized so that reading and writing the item availability is done by a thread at a time
     */
    @Override
    public synchronized Map<Long, String> createOrder(List<Order> orderDetails, String accountId) {
            Map<Long, String> unavailableItems =
                    inventoryService.availabilityCheck(orderDetails);
            if(!CollectionUtils.isEmpty(unavailableItems) && !unavailableItems.containsValue(Response.ResponseType.OUT_OF_STOCK.toString())){
                /*
                 Creating an order for every item placed
                 */
                List<OrderTrackingDetails> orderTrackingDetailList = new ArrayList<>();
        OrderTrackingDetails orderTrackingDetails;
                    for(Order order : orderDetails){
                        order.setId(ObjectId.get().toString());
                        order.setOrderStatus(Order.Status.PLACED);
                        orderTrackingDetails = new OrderTrackingDetails(accountId, OrderTrackingDetails.TrackingStatus.PLACED, null);
                        orderTrackingDetails.setId(ObjectId.get().toString());
                        orderTrackingDetails.setOrderId(order.getId());
                        order.setOrderTrackingDetails(orderTrackingDetails);
                        orderTrackingDetailList.add(orderTrackingDetails);
                    }
                    orderRepository.saveAll(orderDetails);
                    orderTrackingDetailsRepository.saveAll(orderTrackingDetailList);
        //TODO- An Executor service for updating the inventory details upon placing an order
            }
            return unavailableItems;
    }

    @Override
    public String modifyOrder(Order orderDetails, Long orderId) {
        //TODO
        return null;
    }

    @Override
    public String deleteOrder(Long orderId) {
        //TODO
        return null;
    }
}
