package com.rberidon.contact.android.list;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.ListManager;
import com.rberidon.contact.android.datasources.Github;
import com.rberidon.contact.android.item.ListItem;
import com.rberidon.contact.android.views.DefaultActivity;

public class GithubList extends ListItem {
    GithubList self;
    public String username;
    public Github gh;

    public GithubList(String title, Context context, String username) {
        super(title);
        this.self = this;
        this.username = username;
        this.gh = new Github(username);
        this.i = new Intent(context, DefaultActivity.class);
        this.i.putExtra("list", ListManager.GITHUB);
    }
}

