package com.ecommerce.oms.order.model;


import lombok.Data;
import lombok.Synchronized;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class ItemDetails extends BaseModel{
    public enum Unit {
        KG,
        ML,
        L,
        G
    }
    @Id
    private Long id;
    private Long itemId;
    @Version
    private Integer version;
    private Long vendorId;
    private String unit;
    private Integer unitValue;
    private String deviceId;
    private Integer quantityAvailable;
    private Long amount;

    @Synchronized
    public Integer getQuantityAvailable() {
        return quantityAvailable;
    }

    @Synchronized
    public void setQuantityAvailable(Integer quantityAvailable) {
        this.quantityAvailable = quantityAvailable;
    }
}