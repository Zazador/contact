package com.rberidon.contact.android.views;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import com.rberidon.contact.android.R;
import com.rberidon.contact.android.lister.ListAdapter;
import com.rberidon.contact.android.lister.ListManager;

public class DefaultView extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        if (ListManager.getInstance().isValid() == false) {
            ListManager.getInstance().makeLists(getApplicationContext());
        }

        ListAdapter la = getListAdapter();
        la.setItemOnClickListener((ListView) findViewById(android.R.id.list));
        setListAdapter(la);
    }

    public ListAdapter getListAdapter() {
        // To be overridden
        return getListAdapter(ListManager.MAIN, R.layout.item);
    }

    public ListAdapter getListAdapter(String listName, int resource) {
        return (ListManager.getInstance().getList(listName)).getArrayAdapter(getApplicationContext(), resource, "Arvo-BoldItalic_201.ttf", "Arvo-Italic_201.ttf");
    }
}
