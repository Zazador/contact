package com.rberidon.contact.android;

import android.content.Context;
import com.rberidon.contact.android.item.*;
import com.rberidon.contact.android.list.ContactList;
import com.rberidon.contact.android.list.GithubList;

import java.util.ArrayList;
import java.util.HashMap;

public class ListManager {
    // Variables
    public static ListManager instance = null;
    public HashMap<String, ArrayList<ListItem>> lists;

    // Constants
    public static final String MAIN = "main";
    public static final String CONTACT = "contact";
    public static final String GITHUB = "GitHub";

    public ListManager() {
        lists = new HashMap<String, ArrayList<ListItem>>();
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

    public void addList(String key, ArrayList<ListItem> value) {
        lists.put(key, value);
    }

    public ArrayList<ListItem> getList(String key) {
        return lists.get(key);
    }

    public void makeLists(Context context) {
        ListManager lm = ListManager.getInstance();
        Note.d("Making lists.");

        ArrayList<ListItem> main = new ArrayList<ListItem>();
        main.add(new TitleItem("Rayne Beridon"));
        main.add(new ContactList(context, "Contact"));
        main.add(new GithubList("GitHub", context, "rberidon"));
        main.add(new LinkItem(context, "Twitter", "@rberidon", "http://www.twitter.com/rberidon"));
        main.add(new LinkItem(context, "Facebook", "rberidon", "http://www.facebook.com/rberidon"));
        main.add(new LinkItem(context, "LinkedIn", "", "http://www.linkedin.com/profile/view?id=13719225"));
        main.add(new LinkItem(context, "Resume", "", "http://www.rberidon.com/RayneBeridonResume.pdf"));
        lm.addList(MAIN, main);

        ArrayList<ListItem> l = new ArrayList<ListItem>();
        l.add(new ImageItem(context, "gravatar", R.drawable.ring));
        l.add(new TitleItem("Rayne Beridon"));
        l.add(new SMSItem(context, "Phone", "(936) 647.0277"));
        l.add(new EmailItem(context, "Email", "rberidon@gmail.com"));
        l.add(new LinkItem(context, "Website", "rberidon.com", "http://www.rberidon.com"));
        l.add(new LatLongItem(context, "Address", "2801 Rio Grande, Apt 206, Austin, TX 78705", "30.29356", "-97.74372"));
        lm.addList(CONTACT, l);
    }
}
