package com.ecommerce.oms.order.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class AccountAddressDetails extends BaseModel{
    @Id
    private long id;
    private long accountId;
    private String workAddress;
    private String workPincode;
    private String residentialAddress;
    private String residentialPincode;
}