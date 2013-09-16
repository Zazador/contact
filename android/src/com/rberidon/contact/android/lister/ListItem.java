package com.rberidon.contact.android.lister;

import android.content.Context;
import android.content.Intent;

public class ListItem {
    public String title;
    public String subtitle;
    public Intent intent;

    public ListItem(String title) {
        this.title = title;
    }

    public ListItem(String title, String subtitle) {
        this(title);
        this.subtitle = subtitle;
    }

    public void launchIntent(Context context) {
        if (intent != null) {
            context.startActivity(intent);
        }
    }

    @Override
    public String toString() {
        return "ListItem{" +
                "title='" + title + '\'' +
                '}';
    }
}
