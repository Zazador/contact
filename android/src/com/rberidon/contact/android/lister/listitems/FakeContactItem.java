package com.rberidon.contact.android.lister.listitems;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.datasources.Github;
import com.rberidon.contact.android.datasources.GithubRepo;
import com.rberidon.contact.android.lister.List;
import com.rberidon.contact.android.lister.ListItem;
import com.rberidon.contact.android.lister.ListManager;
import com.rberidon.contact.android.views.GithubView;

public class FakeContactItem extends ListItem {
    FakeContactItem self;
    public String one;
    public String two;

    @Override
    public void launch(Context context) {
        super.launch(context);
    }

    public FakeContactItem(Context context, String one, String two) {
        super(one, two);
        this.one = one;
        this.two = two;
        this.self = this;

        //this.i = new Intent(context, GithubView.class);
    }
}

