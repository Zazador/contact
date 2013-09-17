package com.rberidon.contact.android.views;

import com.rberidon.contact.android.R;
import com.rberidon.contact.android.ListAdapter;
import com.rberidon.contact.android.ListManager;

public class FakeContactView extends DefaultView {
    @Override
    public ListAdapter getListAdapter() {
        return new ListAdapter(getApplicationContext(), R.layout.item, R.layout.item_twoline,
                ListManager.getInstance().getList("Contact").items
                , "Arvo-BoldItalic_201.ttf", "Arvo-Italic_201.ttf");

    }
}
