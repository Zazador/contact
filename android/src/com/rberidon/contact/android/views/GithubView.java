package com.rberidon.contact.android.views;

import com.rberidon.contact.android.R;
import com.rberidon.contact.android.ListAdapter;
import com.rberidon.contact.android.ListManager;
import com.rberidon.contact.android.datasources.Constants;

public class GithubView extends DefaultView {
    @Override
    public ListAdapter getListAdapter() {
        return new ListAdapter(getApplicationContext(), R.layout.item_twoline,
                ListManager.getInstance().getList("Github").items,
                Constants.type_regular, Constants.type_bold);

    }
}
