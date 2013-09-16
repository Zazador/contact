package com.rberidon.contact.android.lister;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ListItem {
    public String title;
    public String subtitle;

    public ListItem(String title) {
        this.title = title;
    }

    public ListItem(String title, String subtitle) {
        this(title);
        this.subtitle = subtitle;
    }

    public void setupView(View v, int position) {
        // To be overridden
        v.setClickable(false);
    }

    public boolean isBold() {
        return false;
    }

    public boolean isClickable() {
        return false;
    }
}
