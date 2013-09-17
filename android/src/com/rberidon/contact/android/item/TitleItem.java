package com.rberidon.contact.android.item;

public class TitleItem extends ListItem {
    public TitleItem(String title) {
        super(title);
    }

    @Override
    public boolean isBold() {
        return true;
    }
}
