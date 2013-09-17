package com.rberidon.contact.android.lister;

import android.content.Context;
import com.rberidon.contact.android.Note;
import com.rberidon.contact.android.lister.item.*;
import com.rberidon.contact.android.lister.list.FakeContactList;
import com.rberidon.contact.android.lister.list.GithubList;

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
        main.addItem(new GithubList("Github", context, "rberidon"));
        main.addItem(new LinkItem("Twitter", "@rberidon", "http://www.twitter.com/rberidon"));
        main.addItem(new LinkItem("Facebook", "rberidon", "http://www.facebook.com/rberidon"));
        main.addItem(new LinkItem("LinkedIn", "", "http://www.linkedin.com/profile/view?id=13719225"));
        main.addItem(new LinkItem("Resume", "", "http://www.rberidon.com/RayneBeridonResume.pdf"));

        List test = new List("test");
        test.reset();
        test.addItem(new TitleItem("Test list"));
        test.addItem(new TitleItem("Test list 2"));
        test.addItem(new TitleItem("Test list 3"));

        List l = new List("Contact");
        l.addItem(new TitleItem("Rayne Beridon"));
        l.addItem(new SMSItem(context, "Phone", "(936) 647.0277"));
        l.addItem(new EmailItem(context, "Email", "rberidon@gmail.com"));
        l.addItem(new LinkItem("Website", "rberidon.com", "http://www.rberidon.com"));
        l.addItem(new LatLongItem(context, "Address", "2801 Rio Grande, Apt 206, Austin, TX 78705", "30.29356","-97.74372"));

        ListManager.getInstance().addList("Contact", l);

        //main.addItem(new SubList("goto test", "goto test2", context, "test"));
    }
}
