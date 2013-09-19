package com.rberidon.contact.android.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class LinkItem extends ListItem {
    public LinkItem(Context context, String title, String subtitle, String url) {
        super(title, subtitle, context);

        i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setData(Uri.parse(url));
    }
}
