package com.rberidon.contact.android.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class LatLongItem extends ListItem {
    LatLongItem self;
    String lat;
    String lng;

    public LatLongItem(Context context, String one, String two, String lat, String lng) {
        super(one, two, context);
        this.context = context;
        this.self = this;
        this.lat = lat;
        this.lng = lng;

        i = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + lat + "," + lng + "?q=" + lat + "," + lng + "(" + two + ")"));
    }
}

