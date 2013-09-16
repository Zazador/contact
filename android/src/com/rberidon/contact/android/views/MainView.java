package com.rberidon.contact.android.views;

import com.rberidon.contact.android.R;
import com.rberidon.contact.android.lister.ListAdapter;
import com.rberidon.contact.android.lister.ListManager;

public class MainView extends DefaultView {
    @Override
    public ListAdapter getListAdapter() {
        return super.getListAdapter(ListManager.MAIN, R.layout.item, R.layout.item);
    }
}
