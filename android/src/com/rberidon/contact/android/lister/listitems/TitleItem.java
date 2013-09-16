package com.rberidon.contact.android.lister.listitems;

import com.rberidon.contact.android.lister.ListItem;

public class TitleItem extends ListItem {
    public TitleItem(String title) {
        super(title);
    }

    @Override
    public boolean isBold() {
        return true;
    }
}
