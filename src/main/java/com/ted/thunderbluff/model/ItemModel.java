package com.ted.thunderbluff.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ted.thunderbluff.model.pojo.ItemPOJO;
import com.ted.thunderbluff.model.pojo.ItemXML;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.*;


@Entity
@Table(name = "Item")
public class ItemModel {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @OneToMany(mappedBy = "itemModel", cascade = CascadeType.ALL)
    private Set<Category> categories = new HashSet<>();

    @Column
    private Long currently;

    @Column
    @NotNull
    private Long buy_price;

    @Column
    @NotNull
    private Long first_bid;

    @Column
    private Integer number_of_bids;


    @OneToMany(mappedBy = "itemModel", cascade = CascadeType.ALL)
    private Set<Bid> bids = new HashSet<>();

    @Column
    @NotNull
    private Timestamp started;

    @Column
    @NotNull
    private Timestamp ends;

    @Column
    private String location;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SELLER_ID", referencedColumnName = "ID")
    private UserModel userModel;

    @Column
    @NotNull
    private String description;

    public ItemModel() {
    }

    public ItemModel(@NotNull String name, @NotNull Timestamp started, @NotNull Long buy_price,
                     @NotNull Long first_bid, @NotNull Timestamp ends, @NotNull String location,
                     Integer number_of_bids, Long currently,
                     @NotNull String description, Set<Category> categories,Set<Bid> bids  ) {
        this.name = name;
        this.categories = categories;
        this.currently = currently;
        this.buy_price = buy_price;
        this.first_bid = first_bid;
        this.number_of_bids = number_of_bids;
        this.started = started;
        this.ends = ends;
        this.bids = bids;
        this.location = location;
        this.description = description;
    }

    public ItemPOJO convertToPOJO() {
        return new ItemPOJO(this.name, this.currently, this.buy_price, this.number_of_bids, this.ends, this.location, this.description);
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public String getDescription() {
        return location;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public Set<Bid> getBids() {
        return bids;
    }

    public void setBids(Set<Bid> bids) {
        this.bids = bids;
    }

    public Long getCurrently() { return currently;}

    public void setCurrently(Long currently) { this.currently = currently; }

    public Long getBuy_price() { return buy_price;}

    public void setBuy_price(Long buy_price) { this.buy_price = buy_price; }

    public Long getFirst_bid() { return first_bid;}

    public void setFirst_bid(Long first_bid) { this.first_bid = first_bid; }

    public Integer getNumber_of_bids() { return getBids().size(); }

}

