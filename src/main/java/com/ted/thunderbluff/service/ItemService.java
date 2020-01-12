package com.ted.thunderbluff.service;

import com.ted.thunderbluff.model.UserModel;
import com.ted.thunderbluff.model.ItemModel;
import com.ted.thunderbluff.model.pojo.UserPOJO;
import com.ted.thunderbluff.repository.AuthorityRepository;
import com.ted.thunderbluff.repository.UserModelRepository;
import com.ted.thunderbluff.repository.ItemModelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ItemService {

    @Autowired
    UserModelRepository userModelRepository;

    @Autowired
    AuthorityRepository authorityRepository;

    @Autowired
    ItemModelRepository itemModelRepository;


    public void addItem(ItemModel item) { //make auction praktika ,dhmiourgw items
        itemModelRepository.save(item);
    }

    public List<ItemModel> getAllItems() {
        List<ItemModel> items = new ArrayList<>();
        itemModelRepository.findAll().forEach(items::add);
        return items;
    }


}
