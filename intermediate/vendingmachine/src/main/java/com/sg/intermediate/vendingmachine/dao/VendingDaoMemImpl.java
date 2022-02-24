package com.sg.intermediate.vendingmachine.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sg.intermediate.vendingmachine.dto.Item;

public class VendingDaoMemImpl implements VendingDao {
    Map<String, Item> vendingDb = new HashMap<>();

    @Override
    public List<Item> listItems() {
        return new ArrayList<>(vendingDb.values());
    }

    @Override
    public Item vendItem(String itemToVend) {
        int initialQuantity = vendingDb.get(itemToVend).getQuantity()
        vendingDb.get(itemToVend).setQuantity(initialQuantity - 1);
        return vendingDb.get(itemToVend);
    }

}
