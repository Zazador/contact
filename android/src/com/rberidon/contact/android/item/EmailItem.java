package com.rberidon.contact.android.item;

import android.content.Context;
import android.content.Intent;

public class EmailItem extends ListItem {
    EmailItem self;
    Context context;

    public EmailItem(Context context, String one, String two) {
        super(one, two);
        this.context = context;
        this.self = this;

        i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_SUBJECT, "Contact Information for Rayne Beridon");
        i.putExtra(Intent.EXTRA_TEXT, "Rayne Beridon\nrberidon@gmail.com\n(936) 647.0277");
    }
}

