package com.rberidon.contact.android.item;

import android.content.Intent;
import android.net.Uri;
import com.rberidon.contact.android.Note;

public class LinkItem extends ListItem {
    LinkItem self;

    String url = "";

    public LinkItem(String title, String subtitle, String url) {
        super(title, subtitle);
        this.self = this;
        this.url = url;

        Note.v("Setting up LinkItem: " + title);

        i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setData(Uri.parse(url));
    }
}
