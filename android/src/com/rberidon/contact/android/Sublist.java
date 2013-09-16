package com.rberidon.contact.android;

import android.app.ListActivity;
import android.os.Bundle;
import com.rberidon.contact.android.lister.List;
import com.rberidon.contact.android.lister.ListAdapter;
import com.rberidon.contact.android.lister.ListManager;

public class Sublist extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ListManager lm = ListManager.getInstance();

        List adapterList;
        String listName = getIntent().getStringExtra("ListTitle");
        if (listName != null) {
            adapterList = lm.getList(listName);
        } else {
            Note.e("Failed to get list for name: " + listName + ", so FAILING OUT.");
            return;
        }

        ListAdapter la = adapterList.getArrayAdapter(getApplicationContext(), R.layout.item, "Arvo-BoldItalic_201.ttf", "Arvo-Italic_201.ttf");
        setListAdapter(la);

        Note.i("Started!");
    }
}
