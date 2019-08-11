package com.ecommerce.oms.order.utils;

public class Response {
    public enum ResponseType {
        OUT_OF_STOCK,
        AVAILABLE
    }
    private Integer responseCode;
    private String responseContent;

    public Response(Integer responseCode, String responseContent) {
        this.responseCode = responseCode;
        this.responseContent = responseContent;
    }

    @Override
    public String toString() {
        return "Response{" +
                "responseCode=" + responseCode +
                ", responseContent='" + responseContent + '\'' +
                '}';
    }
}
