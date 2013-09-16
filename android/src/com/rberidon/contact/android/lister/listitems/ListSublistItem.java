package com.rberidon.contact.android.lister.listitems;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.Home;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.lister.ListItem;

public class ListSublistItem extends ListItem {
    ListSublistItem self;
    String sublistName;

    public ListSublistItem(String title, String subtitle, Context context, String sublistName) {
        super(title, subtitle);
        this.self = this;
        this.sublistName = sublistName;

        Note.v("Setting up ListSublistItem: " + title + " with sublist " + sublistName);
        i = new Intent(context, Home.class); // TODO: this won't do anything, but need to find a way to fix
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("ListTitle", sublistName);
    }
}