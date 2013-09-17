package com.rberidon.contact.android.views;

import android.app.ListActivity;
import android.os.Bundle;
import com.rberidon.contact.android.ListAdapter;
import com.rberidon.contact.android.ListManager;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.R;
import com.rberidon.contact.android.datasources.Constants;
import com.rberidon.contact.android.list.List;

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

        ListAdapter la = adapterList.getArrayAdapter(getApplicationContext(), R.layout.item, Constants.type_regular, Constants.type_bold);
        setListAdapter(la);

        Note.i("Started!");
    }
}
