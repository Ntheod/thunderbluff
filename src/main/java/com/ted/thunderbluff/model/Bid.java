package com.ted.thunderbluff.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Table(name = "BID")
public class Bid {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private Long amount;

    @Column
    @NotNull
    private Timestamp time;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    @JsonIgnore
    private UserModel userModel;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    @JsonIgnore
    private ItemModel itemModel;


    public Bid() {
    }

    public Bid(@NotNull Long amount, @NotNull Timestamp time, UserModel userModel, ItemModel itemModel) {
        this.amount = amount;
        this.time = time;
        this.userModel = userModel;
        this.itemModel = itemModel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAmount(){
        return amount;
    }
    public void setAmount(){
        this.amount = amount;
    }

    public Timestamp getTime(){
        return time;
    }
    public void setTime(){
        this.time = time;
    }

    public UserModel getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModel userModel) {
        this.userModel = userModel;
    }

    public ItemModel getItemModel() {
        return itemModel;
    }

    public void setItemModel(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

}
