package com.rberidon.contact.android.lister;

import android.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ListAdapter extends ArrayAdapter<ListItem> {
    private Context context;

    public ListAdapter(Context context, int resource, ArrayList<ListItem> objects) {
        super(context, resource, objects);
        this.context = context;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.two_line_list_item, null);
        }

        ListItem item = getItem(position);
        if (item != null) {
            TextView lineOneView = (TextView) view.findViewById(android.R.id.text1);
            TextView lineTwoView = (TextView) view.findViewById(android.R.id.text2);

            if (lineOneView != null) {
                lineOneView.setText(item.title);
            }

            if (lineTwoView != null) {
                lineTwoView.setText(item.subtitle);
            }
        }

        return view;
    }
}
