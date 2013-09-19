package com.rberidon.contact.android.views;

import com.rberidon.contact.android.ListAdapter;
import com.rberidon.contact.android.ListManager;

public class GithubView extends DefaultView {
    @Override
    public ListAdapter getListAdapter() {
        return new ListAdapter(getApplicationContext(), ListManager.getInstance().getList("Github").items);
    }
}
