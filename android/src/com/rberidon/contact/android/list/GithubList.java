package com.rberidon.contact.android.list;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.datasources.Github;
import com.rberidon.contact.android.datasources.GithubRepo;
import com.rberidon.contact.android.item.ListItem;
import com.rberidon.contact.android.ListManager;
import com.rberidon.contact.android.item.GithubRepoItem;
import com.rberidon.contact.android.item.LinkItem;
import com.rberidon.contact.android.views.GithubView;

public class GithubList extends ListItem {
    GithubList self;
    public String username;
    public Github gh;
    
    @Override
    public void launch(Context context) {
        super.launch(context);
    }

    public GithubList(String title, Context context, String username) {
        super(title);
        this.self = this;
        this.username = username;
        this.gh = new Github(username);
        this.i = new Intent(context, GithubView.class);

        List l = new List("Github");

        l.addItem(new LinkItem("Github", "@rberidon", "http://www.github.com/rberidon"));
        for (GithubRepo r : gh.repos) {
            l.addItem(new GithubRepoItem(context, r));
        }
        ListManager.getInstance().addList("Github", l);
    }
}

