package org.example.logic.dto;

import org.springframework.stereotype.Component;
    @Component

public class ProductDto {
    private String id;
    private String name;
    private String picture;
    private String size;
    private String alt;
    private String price;
    private String rating;
    private String description;
    public ProductDto(){}
    public ProductDto(String id, String name, String picture, String size, String alt, String price, String rating, String description) {
        this.id = id;
        this.name = name;
        this.picture = picture;
        this.size = size;
        this.alt = alt;
        this.price = price;
        this.rating = rating;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
