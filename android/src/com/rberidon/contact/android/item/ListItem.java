package com.rberidon.contact.android.item;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.rberidon.contact.android.Note;

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
        try {
            if (i != null) {
                context.startActivity(i);
            }
        } catch (ActivityNotFoundException e) {
            Note.e("Activity not found for intent: " + i.toString());
        }
    }

}
