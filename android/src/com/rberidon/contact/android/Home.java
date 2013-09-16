package com.rberidon.contact.android;

import android.app.ListActivity;
import android.os.Bundle;
import com.rberidon.contact.android.lister.List;
import com.rberidon.contact.android.lister.ListAdapter;
import com.rberidon.contact.android.lister.ListItem;

public class Home extends ListActivity {
    String[] listItems = {"item 1", "item 2 ", "list", "android", "item 3", "foobar", "bar", };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //setListAdapter(new ArrayAdapter(this,  android.R.layout.simple_list_item_1, listItems));
        List l = new List("test");
        l.addItem(new ListItem("Rayne Beridon", "sub1"));
        l.addItem(new ListItem("Github", "@rberidon"));
        l.addItem(new ListItem("Twitter", "@rberidon"));


        ListAdapter la = l.getArrayAdapter(getApplicationContext(), R.layout.item, "Arvo-BoldItalic_201.ttf", "Arvo-Italic_201.ttf");
        la.setBoldFirstEntry(true);
        setListAdapter(la);
    }

    public void makeLists() {
        List p2 = new List("pageTwo");

    }
}
