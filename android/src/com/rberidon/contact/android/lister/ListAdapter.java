package com.rberidon.contact.android.lister;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.rberidon.contact.android.Note;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListItem> {
    // android
    private Context context;

    // typefaces
    private Typeface type_regular;
    private Typeface type_bold;

    // layout
    private int listResource;

    public ListAdapter(Context context, int resource, ArrayList<ListItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.listResource = resource;
    }

    public ListAdapter(Context context, int resource, ArrayList<ListItem> objects, String boldFont, String font) {
        this(context, resource, objects);
        this.type_regular = Typeface.createFromAsset(context.getAssets(), font);
        this.type_bold = Typeface.createFromAsset(context.getAssets(), boldFont);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Note.v("called GetView on position " + position);
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(listResource, null);
        }

        ListItem item = getItem(position);
        if (item != null) {
            // Layout
            item.setupView(convertView, position);
            convertView.setClickable(item.isClickable());
            Note.d("Setting clickable: " + item.isClickable() + " for item: " + item.title);

            // Text
            setText(convertView.findViewById(android.R.id.text1), item.title, item.isBold() ? type_bold : type_regular);
            setText(convertView.findViewById(android.R.id.text2), item.subtitle, type_regular);
        }

        return convertView;
    }

    public void setText(View v, String text, Typeface t) {
        TextView view = (TextView) v;
        if (view != null && text != null) {
            view.setText(text);
        }

        if (view != null && t != null) {
            view.setTypeface(t);
        }
    }
}
