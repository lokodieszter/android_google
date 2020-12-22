package com.example.curs2.week4;

import java.util.ArrayList;
import java.util.List;

public class DataSource {
    static List<Item> getItems(int itemCount)
    {
        List<Item> list = new ArrayList<>(itemCount);
        for (int i=1; i<=itemCount; i++)
        {
            list.add(new Item("Firstname"+i, "Lastname"+i));
        }
        return list;
    }
}
