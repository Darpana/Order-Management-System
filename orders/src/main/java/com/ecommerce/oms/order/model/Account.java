package com.ecommerce.oms.order.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Account extends BaseModel{
    @Id
    private long id;
    private String firstName;
    private String lastName;
    private String phneNumber;
    private String deviceId;
    private AccountAddressDetails accountAddressDetails;
}