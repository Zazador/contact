package com.rberidon.contact.android.lister;

public class ListTitleItem extends ListItem {
    public ListTitleItem(String title) {
        super(title);
    }

    @Override
    public boolean isBold() {
        return true;
    }

    @Override
    public boolean isClickable() {
        return false;
    }
}
