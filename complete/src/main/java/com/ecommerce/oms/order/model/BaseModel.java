package com.ecommerce.oms.order.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public abstract class BaseModel<T> {
    T model;

    @CreatedDate
    protected Date createdAt;
    @LastModifiedDate
    protected Date updatedAt;

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

}
