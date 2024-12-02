package org.example.logic.dto;

public class OrderDto {
    private String quantity;
    private String region;
    private String date;
    private String price;
    private String userid;

    public OrderDto(String quantity, String region, String date, String price, String userid) {
        this.quantity = quantity;
        this.region = region;
        this.date = date;
        this.price = price;
        this.userid = userid;
    }
    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }
}
