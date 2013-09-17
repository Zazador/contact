package com.rberidon.contact.android.item;

import android.content.Context;
import android.content.Intent;
import android.view.View;

public class ListItem {
    public String title;
    public String subtitle;
    public Intent i;

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

    public boolean hasSubtitle() {
        return (subtitle != null && !subtitle.isEmpty());
    }

    public void launch(Context context) {
        if (i != null) {
            context.startActivity(i);
        }
    }

}
