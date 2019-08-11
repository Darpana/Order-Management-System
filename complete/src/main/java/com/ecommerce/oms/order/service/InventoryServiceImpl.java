package com.ecommerce.oms.order.service;

import com.ecommerce.oms.order.dao.ItemDetailsRepository;
import com.ecommerce.oms.order.dao.ItemRepository;
import com.ecommerce.oms.order.model.ItemDetails;
import com.ecommerce.oms.order.model.Order;
import com.ecommerce.oms.order.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InventoryServiceImpl implements InventoryService{

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ItemDetailsRepository itemDetailsRepository;

    @Override
    public Map<Long, String> availabilityCheck(final List<Order> orderDetails){
        Map<Long, String> unavailableItems = new HashMap<>();
        for(Order order : orderDetails){
            boolean available = isItemAvailable(order);
            if(!available){
                unavailableItems.put(order.getItemId(), Response.ResponseType.OUT_OF_STOCK.toString());
            }else
                unavailableItems.put(order.getItemId(), Response.ResponseType.AVAILABLE.toString());
        }
        return unavailableItems;
    }

    @Override
    public boolean isItemAvailable(final Order orderDetails) {
        ItemDetails itemDetails = itemDetailsRepository.findByItemIdandUnitandUnitValue(orderDetails.getItemId(), orderDetails.getUnit(), orderDetails.getUnitValue());
        if(itemDetails!=null && itemDetails.getQuantityAvailable()>=orderDetails.getQuantity()){
            return true;
        }
        return false;
    }
}
