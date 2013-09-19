package com.rberidon.contact.android.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class SMSItem extends ListItem {
    Context context;

    public SMSItem(Context context, String one, String two) {
        super(one, two);
        this.context = context;

        i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("sms", "", null));
        i.putExtra("sms_body", "Rayne Beridon\nrberidon@gmail.com"  );
    }
}

