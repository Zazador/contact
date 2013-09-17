package com.rberidon.contact.android.lister.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.rberidon.contact.android.lister.ListItem;

public class LatLongItem extends ListItem {
    LatLongItem self;
    Context context;
    String lat;
    String lng;

    public LatLongItem(Context context, String one, String two, String lat, String lng) {
        super(one, two);
        this.context = context;
        this.self = this;
        this.lat = lat;
        this.lng = lng;

        i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:"+lat+","+lng+"?q="+lat+","+lng+"("+two+")"));
    }
}

