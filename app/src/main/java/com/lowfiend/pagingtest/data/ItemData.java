package com.lowfiend.pagingtest.data;

import com.lowfiend.pagingtest.model.Item;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Neyo on 2018/12/10.
 */
public class ItemData {

    public static List<Item> getItem(int size) {
        List<Item> itemList = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            Item item = new Item();
            item.setId(i);
            item.setName("Item " + i);
            itemList.add(item);
        }

        return itemList;
    }

    public static List<Item> getIncreaseItems(int start, int size) {

        List<Item> itemList = new ArrayList<>();

        for (int i = start; i <= size + start; i++) {
            Item item = new Item();
            item.setId(i);
            item.setName("Item " + i);
            itemList.add(item);
        }
        return itemList;
    }

}
