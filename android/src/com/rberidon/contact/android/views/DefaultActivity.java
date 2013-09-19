package com.rberidon.contact.android.views;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ListView;
import com.rberidon.contact.android.ListAdapter;
import com.rberidon.contact.android.ListManager;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.R;
import com.rberidon.contact.android.datasources.Constants;
import com.rberidon.contact.android.datasources.DataManager;

public class DefaultActivity extends ListActivity {
    private DisplayMetrics metrics;

    public static Intent getIntent(Context context, String list) {
        Intent i = new Intent(context, DefaultActivity.class);
        i.putExtra("list", list);
        return i;
    }

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

        if (Constants.type_bold == null) {
            Constants.type_bold = Typeface.createFromAsset(getApplicationContext().getAssets(), Constants.font_bold);
        }

        if (Constants.type_reg == null) {
            Constants.type_reg = Typeface.createFromAsset(getApplicationContext().getAssets(), Constants.font_reg);
        }

        String list = getIntent().getStringExtra("list");
        Note.d("Checking list... " + (list == null ? "null! " : list));
        if (list == null) {
            Note.d("... no list, assuming MAIN");
            list = ListManager.MAIN;
        } else if (ListManager.getInstance().getList(list) == null) {
            Note.d("Null list from LM");
            list = ListManager.MAIN;
        }

        ListAdapter la = new ListAdapter(getApplicationContext(), (ListManager.getInstance().getList(list)));
        la.setItemOnClickListener((ListView) findViewById(android.R.id.list));
        setListAdapter(la);
    }
}
