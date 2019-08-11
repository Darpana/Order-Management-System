package com.ecommerce.oms.order.model;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.mongodb.util.JSON;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Vendor extends BaseModel{
    @Id
    private long id;
    private String name;
    private String address;
    private String contact;
    private String pincode;
    private String extra;
}