package com.rberidon.contact.android.views;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ListView;
import com.rberidon.contact.android.lister.List;
import com.rberidon.contact.android.lister.ListAdapter;
import com.rberidon.contact.android.lister.ListManager;
import com.rberidon.contact.android.lister.listitems.LinkItem;
import com.rberidon.contact.android.lister.listitems.SublistItem;
import com.rberidon.contact.android.lister.listitems.TitleItem;
import com.rberidon.contact.android.views.DefaultView;

public class MainView extends DefaultView {
    @Override
    public ListAdapter getListAdapter() {
        return super.getListAdapter(ListManager.MAIN);
    }
}
