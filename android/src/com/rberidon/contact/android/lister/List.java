package com.rberidon.contact.android.lister;

import android.content.Context;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class List {
    public String name;
    public ArrayList<ListItem> items;

    public List(String name) {
        this.name = name;
        items = new ArrayList<ListItem>();
    }

    public boolean isValid() {
        return (name != null && !name.isEmpty()) && (items != null && !items.isEmpty());
    }

    public void addItem(ListItem item) {
        if (items == null) {
            items = new ArrayList<ListItem>();
        }

        items.add(item);
    }

    public void removeItem(ListItem item) {
        if (items != null) {
            items.remove(item);
        }
    }

    public ArrayAdapter getArrayAdapter(Context context, int resource) {
        return new ListAdapter(context, resource, items);
    }

}
