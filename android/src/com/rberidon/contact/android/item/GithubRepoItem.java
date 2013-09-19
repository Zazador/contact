package com.rberidon.contact.android.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.rberidon.contact.android.datasources.GitHubDataSource;

public class GitHubRepoItem extends ListItem {
    GitHubRepoItem self;
    Context context;
    public GitHubDataSource.GitHubRepo repo;

    public GitHubRepoItem(Context context, GitHubDataSource.GitHubRepo repo) {
        super(repo.name, repo.description, context);
        this.self = this;
        this.repo = repo;
        this.context = context;

        i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setData(Uri.parse("http://www.gitHubDataSource.com/" + repo.full_name));
    }
}

