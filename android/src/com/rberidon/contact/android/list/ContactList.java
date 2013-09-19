package com.rberidon.contact.android.list;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.ListManager;
import com.rberidon.contact.android.item.ListItem;
import com.rberidon.contact.android.views.DefaultActivity;

public class ContactList extends ListItem {
    ContactList self;
    public String one;

    public ContactList(Context context, String one) {
        super(one);
        this.self = this;

        this.i = new Intent(context, DefaultActivity.class);
        this.i.putExtra("list", ListManager.CONTACT);
    }
}