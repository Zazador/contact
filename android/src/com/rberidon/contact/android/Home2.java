package com.rberidon.contact.android;

import android.app.ListActivity;
import android.os.Bundle;
import com.rberidon.contact.android.lister.*;
import com.rberidon.contact.android.lister.listitems.ListLinkItem;
import com.rberidon.contact.android.lister.listitems.ListSublistItem;
import com.rberidon.contact.android.lister.listitems.ListTitleItem;

public class Home2 extends ListActivity {
    String[] listItems = {"item 1", "item 2 ", "list", "android", "item 3", "foobar", "bar", };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //setListAdapter(new ArrayAdapter(this,  android.R.layout.simple_list_item_1, listItems));
        ListManager lm = ListManager.getInstance();

        List main = lm.getList(ListManager.MAIN);
        main.addItem(new ListTitleItem("Rayne Beridon"));
        main.addItem(new ListLinkItem("Github", "@rberidon", "http://www.github.com/rberidon"));
        main.addItem(new ListLinkItem("Twitter", "@rberidon", "http://www.twitter.com/rberidon"));

        List test = lm.getList("test");
        test.addItem(new ListTitleItem("Test list"));
        test.addItem(new ListTitleItem("Test list 2"));
        test.addItem(new ListTitleItem("Test list 3"));

        main.addItem(new ListSublistItem("goto test", "goto test2", getApplicationContext(), "test"));

        List adapterList;
        String listName = getIntent().getStringExtra("ListTitle");
        if (listName == null) {
            Note.w("Failed to get list for name: " + listName + ", so setting MAIN");
            adapterList = lm.getList(ListManager.MAIN);
        } else {
            adapterList = lm.getList(listName);
        }

        ListAdapter la = adapterList.getArrayAdapter(getApplicationContext(), R.layout.item, "Arvo-BoldItalic_201.ttf", "Arvo-Italic_201.ttf");
        setListAdapter(la);

        Note.i("Started!");
    }

    public void makeLists() {
        List p2 = new List("pageTwo");

    }
}
