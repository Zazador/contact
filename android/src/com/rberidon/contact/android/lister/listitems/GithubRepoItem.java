package com.rberidon.contact.android.lister.listitems;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.rberidon.contact.android.datasources.DataManager;
import com.rberidon.contact.android.datasources.Github;
import com.rberidon.contact.android.datasources.GithubRepo;
import com.rberidon.contact.android.lister.ListItem;
import com.rberidon.contact.android.views.GithubView;

public class GithubRepoItem extends ListItem {
    GithubRepoItem self;
    Context context;
    public GithubRepo repo;

    @Override
    public void launch(Context context) {
        super.launch(context);
    }

    public GithubRepoItem(Context context, GithubRepo repo) {
        super(repo.name, repo.description);
        this.self = this;
        this.repo = repo;
        this.context = context;

        i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setData(Uri.parse("http://www.github.com/" + repo.full_name));
    }
}

