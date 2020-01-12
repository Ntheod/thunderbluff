package com.ted.thunderbluff.model.pojo;

import java.sql.Timestamp;

public class ItemPOJO {

    private String name;

    private Long currently;

    private Long buy_price;

    private Integer number_of_bids;

    private Timestamp ends;

    private String location;

    private String description;


    public ItemPOJO() {
    }

    public ItemPOJO(String name, Long currently, Long buy_price,Integer number_of_bids , Timestamp ends,String location ,String description) {
        this.name = name;
        this.currently = currently;
        this.buy_price = buy_price;
        this.number_of_bids = number_of_bids;

        this.ends = ends;
        this.location = location;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCurrently(Long currently) {
        this.currently = currently;
    }

    public Long getCurrently() {
        return currently;
    }

    public Long getBuy_price() {
        return buy_price;
    }

    public void setBuy_price(Long buy_price) {
        this.buy_price = buy_price;
    }

    public Integer getNumber_of_bids() {
        return number_of_bids;
    }

    public void setNumber_of_bids(Integer number_of_bids) {
        this.number_of_bids = number_of_bids;
    }

    public Timestamp getEnds() {
        return ends;
    }

    public void setEnds(Timestamp ends) {
        this.ends = ends;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
