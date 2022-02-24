package com.sg.intermediate.vendingmachine.dao;

import java.util.List;

import com.sg.intermediate.vendingmachine.dto.Item;

public interface VendingDao {
    /**
     * 
     * @return list of items in the vending machine
     */
    List<Item> listItems();

    Item vendItem(String itemToVend);

}
