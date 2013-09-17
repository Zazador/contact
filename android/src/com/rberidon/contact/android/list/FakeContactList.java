package com.rberidon.contact.android.list;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.item.ListItem;
import com.rberidon.contact.android.views.FakeContactView;

public class FakeContactList extends ListItem {
    FakeContactList self;
    public String one;

    @Override
    public void launch(Context context) {
        super.launch(context);
    }

    public FakeContactList(Context context, String one) {
        super(one);
        this.self = this;

        this.i = new Intent(context, FakeContactView.class);
    }
}

