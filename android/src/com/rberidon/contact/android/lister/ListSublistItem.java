package com.rberidon.contact.android.lister;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.rberidon.contact.android.Home;
import com.rberidon.contact.android.Note;

public class ListSublistItem extends ListItem {
    private Intent i;
    ListSublistItem self;
    String sublistName;

    public ListSublistItem(String title, String subtitle, Context context, String sublistName) {
        super(title, subtitle);
        this.self = this;
        this.sublistName = sublistName;

        Note.v("Setting up ListSublistItem: " + title + " with sublist " + sublistName);
        Intent i = new Intent(context, Home.class); // TODO: this won't do anything, but need to find a way to fix
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("ListTitle", sublistName);
        this.i = i;
    }

    @Override
    public boolean isClickable() {
        Note.d("Setting clickable: " + (i != null) + " for " + this.title);
        if (i != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setupView(View v, int position) {
        Note.d("Setting up view for " + this.title);
        v.setOnClickListener(new ListSublistItem.OnClickListener());
    }

    public void launch(Context context) {
        context.startActivity(i);
    }

    private class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Note.i("Going to new list activity from item: " + self.title);
            self.launch(v.getContext());
        }
    }
}
