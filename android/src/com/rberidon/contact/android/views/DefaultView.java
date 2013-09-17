package com.rberidon.contact.android.views;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ListView;
import com.rberidon.contact.android.R;
import com.rberidon.contact.android.datasources.Constants;
import com.rberidon.contact.android.datasources.DataManager;
import com.rberidon.contact.android.ListAdapter;
import com.rberidon.contact.android.ListManager;

public class DefaultView extends ListActivity {
    private DisplayMetrics metrics;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.linear_interpolator);
        setContentView(R.layout.main);

        metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        DataManager.getInstance().metrics = metrics;

        if (ListManager.getInstance().isValid() == false) {
            ListManager.getInstance().makeLists(getApplicationContext());
        }

        ListAdapter la = getListAdapter();
        la.setItemOnClickListener((ListView) findViewById(android.R.id.list));
        setListAdapter(la);
    }

    public ListAdapter getListAdapter() {
        // To be overridden
        return getListAdapter(ListManager.MAIN, R.layout.item, R.layout.item_twoline);
    }

    public ListAdapter getListAdapter(String listName, int resource, int resource2) {
        return new ListAdapter(getApplicationContext(), resource, resource2, (ListManager.getInstance().getList(listName)).items,
                Constants.type_regular, Constants.type_bold);
    }
}
