package com.rberidon.contact.android.lister.item;

import android.content.Context;
import com.rberidon.contact.android.lister.ListItem;

public class FakeContactItem extends ListItem {
    FakeContactItem self;

    @Override
    public void launch(Context context) {
        super.launch(context);
    }

    public FakeContactItem(Context context, String one, String two) {
        super(one, two);
        this.self = this;
    }
}

