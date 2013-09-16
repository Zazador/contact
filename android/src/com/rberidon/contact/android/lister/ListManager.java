package com.rberidon.contact.android.lister;

import java.util.HashMap;

public class ListManager {
    // Variables
    public static ListManager instance = null;
    public HashMap<String, List> lists;

    // Constants
    public static final String MAIN = "main";

    public ListManager() {
        lists = new HashMap<String, List>();
    }

    public static ListManager getInstance() {
        if (instance == null) {
            instance = new ListManager();
        }
        return instance;
    }

    public boolean isValid() {
        return (lists != null && !lists.isEmpty());
    }

    public void addList(String key, List value) {
        if (lists == null) {
            lists = new HashMap<String, List>();
        }

        lists.put(key, value);
    }

    public List getMainList() {
        return getList(this.MAIN);
    }

    public List getList(String key) {
        // will create list MAIN if missing

        if (key == null) {
            return null;
        }

        if (lists.containsKey(key)) {
            return lists.get(key);
        } else {
            List temp = new List(key);
            lists.put(key, temp);
            return temp;
        }
    }
}
