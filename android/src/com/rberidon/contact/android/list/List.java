package com.rberidon.contact.android.list;

import android.content.Context;
import com.rberidon.contact.android.ListAdapter;
import com.rberidon.contact.android.item.ListItem;

import java.util.ArrayList;

public class List {
    public String name;
    public ArrayList<ListItem> items;

    public List(String name) {
        this.name = name;
        reset();
    }

    public boolean isValid() {
        return (name != null && !name.isEmpty()) && (items != null && !items.isEmpty());
    }

    public void addItem(ListItem item) {
        if (items == null) {
            reset();
        }

        items.add(item);
    }

    public void removeItem(ListItem item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public void reset() {
        items = new ArrayList<ListItem>();
    }

    public ListAdapter getArrayAdapter(Context context) {
        return new ListAdapter(context, items);
    }
}
