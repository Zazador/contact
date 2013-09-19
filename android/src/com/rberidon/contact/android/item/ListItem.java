package com.rberidon.contact.android.item;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.R;
import com.rberidon.contact.android.datasources.Constants;

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

    public boolean isBold() {
        return false;
    }

    public boolean hasSubtitle() {
        return (subtitle != null && !subtitle.isEmpty());
    }

    public final View getView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(getLayoutResourceId(), null);
        setupView(v);
        return v;
    }

    protected void setupView(View v) {
        TextView t1 = (TextView) v.findViewById(android.R.id.text1);
        TextView t2 = (TextView) v.findViewById(android.R.id.text2);
        if (t1 != null) {
            t1.setText(title);
            t1.setTypeface(isBold() ? Constants.type_bold : Constants.type_reg);
        }
        if (hasSubtitle() && t2 != null) {
            t2.setText(subtitle);
            t2.setTypeface(Constants.type_reg);
        }
    }

    protected int getLayoutResourceId() {
        return (hasSubtitle() ? R.layout.item_twoline : R.layout.item);
    }

    public final void launch(Context context) {
        try {
            if (i != null) {
                context.startActivity(i);
            }
        } catch (ActivityNotFoundException e) {
            Note.e("Activity not found for intent: " + i.toString());
        }
    }

}
