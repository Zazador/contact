package com.rberidon.contact.android.lister.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.rberidon.contact.android.lister.ListItem;

public class SMSItem extends ListItem {
    SMSItem self;
    Context context;

    @Override
    public void launch(Context context) {
        //startEmailActivity(context, null, null, "Rayne Beridon\nrberidon@gmail.com", null);
        Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("sms", "", null));
        i.putExtra("sms_body", "Rayne Beridon\nrberidon@gmail.com"  );
        context.startActivity(i);
    }

    public SMSItem(Context context, String one, String two) {
        super(one, two);
        this.context = context;
        this.self = this;


    }
}

