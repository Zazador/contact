package com.rberidon.contact.android.views;

import com.rberidon.contact.android.ListAdapter;
import com.rberidon.contact.android.ListManager;
import com.rberidon.contact.android.R;

public class MainView extends DefaultView {
    @Override
    public ListAdapter getListAdapter() {
        return super.getListAdapter(ListManager.MAIN, R.layout.item, R.layout.item);
    }
}
