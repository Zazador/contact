package com.rberidon.contact.android.datasources;

import android.util.DisplayMetrics;

import java.util.HashMap;

public class DataManager {
    public static DataManager instance = null;
    public HashMap<String, Data> map;
    public DisplayMetrics metrics;
    public GitHubDataSource gitHubDataSource;

    public DataManager() {
        map = new HashMap<String, Data>();
    }

    public static DataManager getInstance() {
        if (instance == null) {
            instance = new DataManager();
        }
        return instance;
    }

    public void put(String key, Data value) {
        map.put(key, value);
    }

    public Data get(String key) {
        return map.get(key);
    }
}
