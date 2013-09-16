package com.rberidon.contact.android;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import com.rberidon.contact.android.lister.List;
import com.rberidon.contact.android.lister.ListItem;

public class Home extends ListActivity {
    String[] listItems = {"item 1", "item 2 ", "list", "android", "item 3", "foobar", "bar", };

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        //setListAdapter(new ArrayAdapter(this,  android.R.layout.simple_list_item_1, listItems));
        List l = new List("test");
        l.addItem(new ListItem("item1", "sub1"));
        setListAdapter(l.getArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1));
    }
}
