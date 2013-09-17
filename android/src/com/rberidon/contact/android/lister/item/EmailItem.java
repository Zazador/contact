package com.rberidon.contact.android.lister.item;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.rberidon.contact.android.lister.ListItem;

public class EmailItem extends ListItem {
    EmailItem self;
    Context context;

    @Override
    public void launch(Context context) {
        startEmailActivity(context, null, null, "Rayne Beridon\nrberidon@gmail.com\n(936) 647.0277", null);
    }

    public EmailItem(Context context, String one, String two) {
        super(one, two);
        this.context = context;
        this.self = this;


    }

    public void startEmailActivity(Context context,
                                   String[] toAddresses, String emailSubject, String emailBody, Uri attachment) {
        // Assumes email addresses are already verified, so we will not verify them again

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");

        intent.putExtra(Intent.EXTRA_EMAIL, toAddresses);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        intent.putExtra(Intent.EXTRA_TEXT, emailBody);

        /*if (attachment != null) {
            intent.putExtra(Intent.EXTRA_STREAM, attachment);
        }
*/
        context.startActivity(intent);
    }
}

