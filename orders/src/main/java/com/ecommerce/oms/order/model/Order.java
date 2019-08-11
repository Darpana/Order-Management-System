package com.ecommerce.oms.order.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Order extends BaseModel{
    public enum Status{
        PENDING,
        PLACED,
        FAILED;
    }
    @Id
    private String id;
    private long accountId;
    private long itemId;
    private String unit;
    private Long unitValue;
    private int quantity;
    private Status orderStatus;
    private Date placedOn;
    private OrderTrackingDetails orderTrackingDetails;
}