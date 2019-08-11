package com.ecommerce.oms.order.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class OrderTrackingDetails extends BaseModel{
    public enum TrackingStatus{
        PLACED,
        SHIPPED,
        DISPACTHED,
        DELIVERED,
        DELIVERY_FAILED;
    }
    @Id
    private String id;
    private String orderId;
    private String accountId;
    private TrackingStatus trackingStatus;
    private String trackingAddress;
    @DBRef
    private Order order;

    public OrderTrackingDetails(String accountId, TrackingStatus trackingStatus, String trackingAddress) {
        this.accountId = accountId;
        this.trackingStatus = trackingStatus;
        this.trackingAddress = trackingAddress;
    }
}