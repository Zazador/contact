package com.rberidon.contact.android.views;

import com.rberidon.contact.android.R;
import com.rberidon.contact.android.datasources.DataManager;
import com.rberidon.contact.android.datasources.Github;
import com.rberidon.contact.android.lister.ListAdapter;
import com.rberidon.contact.android.lister.ListManager;
import com.rberidon.contact.android.lister.listitems.GithubRepoItem;

import java.util.ArrayList;

public class GithubView extends DefaultView {
    @Override
    public ListAdapter getListAdapter() {
        return new ListAdapter(getApplicationContext(), R.layout.item,
                ListManager.getInstance().getList("Github").items
                , "Arvo-BoldItalic_201.ttf", "Arvo-Italic_201.ttf");

    }
}
