package com.ted.thunderbluff.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Category")
public class Category {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @ManyToOne
    @JoinColumn(name = "ITEM_ID", referencedColumnName = "ID")
    @JsonIgnore
    private ItemModel itemModel;

    public Category() {
    }

    public Category(@NotNull String name, ItemModel itemModel) {
        this.name = name;
        this.itemModel = itemModel;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemModel getItemModel() {
        return itemModel;
    }

    public void setItemModel(ItemModel itemModel) {
        this.itemModel = itemModel;
    }

}
