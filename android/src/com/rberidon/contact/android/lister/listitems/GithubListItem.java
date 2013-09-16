package com.rberidon.contact.android.lister.listitems;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.datasources.Github;
import com.rberidon.contact.android.datasources.GithubRepo;
import com.rberidon.contact.android.lister.List;
import com.rberidon.contact.android.lister.ListItem;
import com.rberidon.contact.android.lister.ListManager;
import com.rberidon.contact.android.views.GithubView;

public class GithubListItem extends ListItem {
    GithubListItem self;
    public String username;
    public Github gh;
//    public ArrayList<GithubRepoItem> items;

    @Override
    public void launch(Context context) {
        super.launch(context);
    }

    public GithubListItem(String title, Context context, String username) {
        super(title);
        this.self = this;
        this.username = username;
        this.gh = new Github(username);
        this.i = new Intent(context, GithubView.class);
//        this.items = new ArrayList<GithubRepoItem>();
        List l = new List("Github");
        for (GithubRepo r : gh.repos) {
            l.addItem(new GithubRepoItem(context, r));
        }
        ListManager.getInstance().addList("Github", l);
    }
}

