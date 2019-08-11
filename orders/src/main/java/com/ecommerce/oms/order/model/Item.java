package com.ecommerce.oms.order.model;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Item extends BaseModel{
    public enum Type{
        VEGETABLES,
        DAIRY,
        FRUITS,
        SNACKS;
    }
    @Id
    private long id;
    private long categoryId;
    private Type type;
    private String name;
    private String extra;
    private ItemDetails itemDetails;
}