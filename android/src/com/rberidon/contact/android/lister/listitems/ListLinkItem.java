package com.rberidon.contact.android.lister.listitems;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.lister.ListItem;

public class ListLinkItem extends ListItem {
    private Intent i;
    ListLinkItem self;

    String url = "";

    public ListLinkItem(String title, String subtitle, String url) {
        super(title, subtitle);
        this.self = this;
        this.url = url;

        Note.v("Setting up ListLinkItem: " + title);

        Intent i = new Intent(Intent.ACTION_VIEW);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setData(Uri.parse(url));
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
        v.setOnClickListener(new ListLinkItem.OnClickListener());
    }

    public void launch(Context context) {
        context.startActivity(i);
    }

    private class OnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Note.i("Launching URL from item: " + self.title + ", URL: " + self.url);
            self.launch(v.getContext());
        }
    }
}
