package com.rberidon.contact.android;

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

public class Home extends ListActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        makeLists();

        ListManager lm = ListManager.getInstance();

        List adapterList;
        String listName = getIntent().getStringExtra("ListTitle");
        if (listName == null) {
            Note.w("Failed to get list for name: " + listName + ", so setting MAIN");
            adapterList = lm.getList(ListManager.MAIN);
        } else {
            adapterList = lm.getList(listName);
        }

        ListAdapter la = adapterList.getArrayAdapter(getApplicationContext(), R.layout.item, "Arvo-BoldItalic_201.ttf", "Arvo-Italic_201.ttf");
        setListAdapter(la);
        la.setItemOnClickListener((ListView) findViewById(android.R.id.list));

        Note.i("Started!");
    }

    public void makeLists() {
        ListManager lm = ListManager.getInstance();

        List main = lm.getList(ListManager.MAIN);
        main.reset();
        main.addItem(new TitleItem("Rayne Beridon"));
        main.addItem(new LinkItem("Github", "@rberidon", "http://www.github.com/rberidon"));
        main.addItem(new LinkItem("Twitter", "@rberidon", "http://www.twitter.com/rberidon"));

        List test = lm.getList("test");
        test.reset();
        test.addItem(new TitleItem("Test list"));
        test.addItem(new TitleItem("Test list 2"));
        test.addItem(new TitleItem("Test list 3"));

        main.addItem(new SublistItem("goto test", "goto test2", getApplicationContext(), "test"));
    }
}
