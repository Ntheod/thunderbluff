package com.ted.thunderbluff.controller;


import com.ted.thunderbluff.model.UserModel;
import com.ted.thunderbluff.model.ItemModel;
import com.ted.thunderbluff.model.pojo.UserPOJO;
import com.ted.thunderbluff.model.pojo.ItemPOJO;
import com.ted.thunderbluff.model.*;
import com.ted.thunderbluff.service.ItemService;
import com.ted.thunderbluff.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemRestController {

    @Value("Authorization")
    private String tokenHeader;

    @Autowired
    private UserService userService;
    @Autowired
    private ItemService itemService;

    @PostMapping("/api/createAuction")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerAccount(@Valid @RequestBody ItemModel item) { itemService.addItem(item);
    }


    public List<ItemModel> getAllItems() {
        List<ItemModel> retList = itemService.getAllItems();
        retList.remove(0);
        return retList;
    }

    @GetMapping("/api/items")
    @PreAuthorize("hasRole('USER')")
    public List<ItemPOJO> getAllItemsPOJO() {
        List<ItemPOJO> retList = new ArrayList<>();
        for (ItemModel item : getAllItems()) {
            retList.add(item.convertToPOJO());
        }
        return retList;
    }



}
