package com.rberidon.contact.android;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.*;
import com.rberidon.contact.android.item.ListItem;

import java.util.ArrayList;
import java.util.HashSet;

public class ListAdapter extends ArrayAdapter<ListItem> {
    // android
    private Context context;

    // typefaces
    private Typeface type_regular;
    private Typeface type_bold;

    // layout
    private int listResourceOne;
    private int listResourceTwo = -1;
    int animOffset = 0;
    int anim = 250;
    int animDelta = 150;
    HashSet<Integer> positions;
    Handler h;


    public ListAdapter(Context context, int resource, ArrayList<ListItem> objects) {
        super(context, resource, objects);
        this.context = context;
        this.listResourceOne = resource;

        h = new Handler();
        positions = new HashSet<Integer>();
    }

    public ListAdapter(Context context, int resourceOne, int resourceTwo, ArrayList<ListItem> objects, String boldFont, String font) {
        this(context, resourceOne, objects, boldFont, font);
        this.listResourceTwo = resourceTwo;
    }

    public ListAdapter(Context context, int resource, ArrayList<ListItem> objects, String boldFont, String font) {
        this(context, resource, objects);
        this.type_regular = Typeface.createFromAsset(context.getAssets(), font);
        this.type_bold = Typeface.createFromAsset(context.getAssets(), boldFont);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Note.d("called GetView on position " + position);

        ListItem item = getItem(position);
        if (item != null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (item.hasSubtitle() && listResourceTwo != -1) {
                convertView = inflater.inflate(listResourceTwo, null);
            } else {
                convertView = inflater.inflate(listResourceOne, null);
            }
            // Layout
            item.setupView(convertView, position);

            // Text
            setText(convertView.findViewById(android.R.id.text1), item.title, item.isBold() ? type_bold : type_regular);
            setText(convertView.findViewById(android.R.id.text2), item.subtitle, type_regular);

            // Animation animation = new TranslateAnimation(DataManager.getInstance().metrics.widthPixels/5, 0, 0, 0);
            Integer temp = new Integer(position);
            if (!positions.contains(temp)) {
                Animation animation = new AlphaAnimation((float)0.0, (float)1.0);
                animation.setDuration(anim + animOffset * position);
                positions.add(temp);

                convertView.startAnimation(animation);
            }
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

    public void setItemOnClickListener(ListView v) {
        v.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ListItem item = getItem(position);
                item.launch(parent.getContext());
            }
        });
    }
}
