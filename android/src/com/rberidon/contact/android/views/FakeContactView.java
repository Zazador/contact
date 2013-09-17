package com.rberidon.contact.android.views;

import com.rberidon.contact.android.R;
import com.rberidon.contact.android.ListAdapter;
import com.rberidon.contact.android.ListManager;
import com.rberidon.contact.android.datasources.Constants;

public class FakeContactView extends DefaultView {
    @Override
    public ListAdapter getListAdapter() {
        return new ListAdapter(getApplicationContext(), R.layout.item, R.layout.item_twoline,
                ListManager.getInstance().getList("Contact").items,
                Constants.type_regular, Constants.type_bold);

    }
}
