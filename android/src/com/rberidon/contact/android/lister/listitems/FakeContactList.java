package com.rberidon.contact.android.lister.listitems;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.lister.List;
import com.rberidon.contact.android.lister.ListItem;
import com.rberidon.contact.android.lister.ListManager;
import com.rberidon.contact.android.views.FakeContactView;
import com.rberidon.contact.android.views.GithubView;

public class FakeContactList extends ListItem {
    FakeContactList self;
    public String one;

    @Override
    public void launch(Context context) {
        super.launch(context);
    }

    public FakeContactList(Context context, String one) {
        super(one);
        this.one = one;
        this.self = this;

        this.i = new Intent(context, FakeContactView.class);

        List l = new List("Contact");
        l.addItem(new TitleItem("Rayne Beridon"));
        l.addItem(new FakeContactItem(context, "Phone", "(936) 647.0277"));
        l.addItem(new FakeContactItem(context, "Email", "rberidon@gmail.com"));

        ListManager.getInstance().addList("Contact", l);
    }
}

