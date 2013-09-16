package com.rberidon.contact.android.lister;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListItem> {
    // android
    private Context context;

    // typefaces
    private Typeface type_regular;
    private Typeface type_bold;

    // layout
    private int listResource;
    private boolean boldFirstEntry = false;

    public ListAdapter(Context context, int resource, ArrayList<ListItem> objects) {
        super(context, resource, objects);
        this.context = context;
//        this.listResource = R.layout.two_line_list_item;
        //this.listResource = R.layout.simple_list_item_1;
        this.listResource = resource;
    }

    public ListAdapter(Context context, int resource, ArrayList<ListItem> objects, String boldFont, String font) {
        this(context, resource, objects);
        this.type_regular = Typeface.createFromAsset(context.getAssets(), font);
        this.type_bold = Typeface.createFromAsset(context.getAssets(), boldFont);
    }

    public void setBoldFirstEntry(boolean b) {
        this.boldFirstEntry = b;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(listResource, null);
        }

        ListItem item = getItem(position);
        if (item != null) {
            TextView lineOneView = (TextView) view.findViewById(android.R.id.text1);
            TextView lineTwoView = (TextView) view.findViewById(android.R.id.text2); // probably null

            if (lineOneView != null) {
                lineOneView.setText(item.title);

                if (position == 0 && boldFirstEntry) {
                    if (type_bold != null) lineOneView.setTypeface(type_bold);
                } else {
                    if (type_regular != null) lineOneView.setTypeface(type_regular);
                }
            }

            if (lineTwoView != null) {
                lineTwoView.setText(item.subtitle);
                if (type_regular != null) lineTwoView.setTypeface(type_regular);
            }
        }

        return view;
    }
}
