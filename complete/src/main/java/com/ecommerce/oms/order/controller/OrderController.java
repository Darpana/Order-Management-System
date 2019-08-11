package com.ecommerce.oms.order.controller;

import com.ecommerce.oms.order.model.Order;
import com.ecommerce.oms.order.service.OrderService;
import com.ecommerce.oms.order.utils.Response;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Map;

@RestController
@Log
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    public ResponseEntity<String> placeOrder(@RequestBody List<Order> orderDetails) {
        //1. Check the availability of the items
        //2. If available, create an entry in order and order details, and send a response
        //3. If not available, send a response with ORDER_OUT_OF_STOCK
        String accountId = orderDetails.get(0).getId();
        try {
            Map<Long, String> itemStatuses = orderService.createOrder(orderDetails, accountId);
            return ResponseEntity.status(HttpStatus.OK).body(new Response(200, itemStatuses.toString()).toString());
        }catch (HttpClientErrorException.BadRequest exception){
            log.info("Request failed for account id " + accountId);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

}
