package com.rberidon.contact.android.lister.list;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.lister.List;
import com.rberidon.contact.android.lister.ListItem;
import com.rberidon.contact.android.lister.ListManager;
import com.rberidon.contact.android.lister.item.*;
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

