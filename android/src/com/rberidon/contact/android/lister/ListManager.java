package com.rberidon.contact.android.lister;

import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ListManager {
    public ArrayList<List> lists;

    public ListManager() {
        lists = new ArrayList<List>();
    }

    public boolean isValid() {
        return (lists != null && !lists.isEmpty());
    }

}
