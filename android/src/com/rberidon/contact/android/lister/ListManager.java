package com.rberidon.contact.android.lister;

import android.content.Context;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.lister.listitems.FakeContactList;
import com.rberidon.contact.android.lister.listitems.GithubListItem;
import com.rberidon.contact.android.lister.listitems.LinkItem;
import com.rberidon.contact.android.lister.listitems.TitleItem;

import java.util.HashMap;

public class ListManager {
    // Variables
    public static ListManager instance = null;
    public HashMap<String, List> lists;

    // Constants
    public static final String MAIN = "main";

    public ListManager() {
        lists = new HashMap<String, List>();
    }

    public static ListManager getInstance() {
        if (instance == null) {
            instance = new ListManager();
        }
        return instance;
    }

    public boolean isValid() {
        return (lists != null && !lists.isEmpty());
    }

    public void addList(String key, List value) {
        lists.put(key, value);
    }

    public List getList(String key) {
        // will create lists if missing

        if (key == null) {
            return null;
        }

        if (lists.containsKey(key)) {
            return lists.get(key);
        } else {
            List temp = new List(key);
            lists.put(key, temp);
            return temp;
        }
    }

    public void makeLists(Context context) {
        ListManager lm = ListManager.getInstance();
        Note.d("Making lists.");

        List main = lm.getList(ListManager.MAIN);
        main.reset();
        main.addItem(new TitleItem("Rayne Beridon"));
        main.addItem(new FakeContactList(context, "Contact"));
        main.addItem(new GithubListItem("Github", context, "rberidon"));
        main.addItem(new LinkItem("Twitter", "@rberidon", "http://www.twitter.com/rberidon"));
        main.addItem(new LinkItem("Facebook", "rberidon", "http://www.facebook.com/rberidon"));
        main.addItem(new LinkItem("LinkedIn", "", "http://www.linkedin.com/profile/view?id=13719225"));
        

        List test = lm.getList("test");
        test.reset();
        test.addItem(new TitleItem("Test list"));
        test.addItem(new TitleItem("Test list 2"));
        test.addItem(new TitleItem("Test list 3"));

        //main.addItem(new SublistItem("goto test", "goto test2", context, "test"));
    }
}
