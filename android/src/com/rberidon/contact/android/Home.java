package com.rberidon.contact.android;

import android.app.ListActivity;
import android.os.Bundle;
import com.rberidon.contact.android.lister.*;

public class Home extends ListActivity {
    String[] listItems = {"item 1", "item 2 ", "list", "android", "item 3", "foobar", "bar", };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //setListAdapter(new ArrayAdapter(this,  android.R.layout.simple_list_item_1, listItems));
        List main = new List("main");
        main.addItem(new ListTitleItem("Rayne Beridon"));
        main.addItem(new ListLinkItem("Github", "@rberidon", "http://www.github.com/rberidon"));
        main.addItem(new ListLinkItem("Twitter", "@rberidon", "http://www.twitter.com/rberidon"));

        ListAdapter la = main.getArrayAdapter(getApplicationContext(), R.layout.item, "Arvo-BoldItalic_201.ttf", "Arvo-Italic_201.ttf");
        setListAdapter(la);

        Note.i("Started!");
    }

    public void makeLists() {
        List p2 = new List("pageTwo");

    }
}
