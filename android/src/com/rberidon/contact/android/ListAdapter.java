package com.rberidon.contact.android;

import android.content.Context;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.rberidon.contact.android.item.ListItem;

import java.util.ArrayList;
import java.util.HashSet;

public class ListAdapter extends ArrayAdapter<ListItem> {
    // android
    private Context context;

    // layout
    int animOffset = 0;
    int anim = 250;
    HashSet<Integer> positions;
    Handler h;


    public ListAdapter(Context context, ArrayList<ListItem> objects) {
        super(context, R.layout.item_twoline, objects);
        this.context = context;

        h = new Handler();
        positions = new HashSet<Integer>();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        Note.d("called GetView on position " + position);

        ListItem item = getItem(position);
        if (item != null) {
            convertView = item.getView(context);

            // Animation animation = new TranslateAnimation(DataManager.getInstance().metrics.widthPixels/5, 0, 0, 0);
            Integer temp = new Integer(position);
            if (!positions.contains(temp)) {
                Animation animation = new AlphaAnimation((float) 0.0, (float) 1.0);
                animation.setDuration(anim + animOffset * position);
                positions.add(temp);

                convertView.startAnimation(animation);
            }
        }

        return convertView;
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
