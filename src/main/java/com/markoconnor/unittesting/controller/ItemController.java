package com.markoconnor.unittesting.controller;

import com.markoconnor.unittesting.business.ItemBusinessService;
import com.markoconnor.unittesting.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ItemController {

    @Autowired
    private ItemBusinessService businessService;

    @GetMapping("/dummy-item")
    public Item dummyItem() {

        return new Item(1, "Ball", 10, 100); // returning some hard coded data calling the Item constructor to initialize the variables
    }

    @GetMapping("/item-from-business-service")
    public Item itemFromBusinessService() {

        return businessService.retrieveHardcodedItem(); // Calling out to the businessService layer.
    }

    @GetMapping("/all-items-from-database")
    public List<Item> retrieveAllItems() {
        return businessService.retrieveAllItems();
    }
}
