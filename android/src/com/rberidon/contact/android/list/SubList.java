package com.rberidon.contact.android.list;

import android.content.Context;
import android.content.Intent;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.item.ListItem;
import com.rberidon.contact.android.views.MainView;

public class SubList extends ListItem {
    SubList self;
    String sublistName;

    public SubList(String title, String subtitle, Context context, String sublistName) {
        super(title, subtitle);
        this.self = this;
        this.sublistName = sublistName;

        Note.v("Setting up SubList: " + title + " with sublist " + sublistName);
        i = new Intent(context, MainView.class); // TODO: this won't do anything, but need to find a way to fix
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("ListTitle", sublistName);
    }
}