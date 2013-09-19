package com.rberidon.contact.android.item;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.rberidon.contact.android.R;

public class ImageItem extends ListItem {
    Drawable image;

    public ImageItem(Context context, String title, int image) {
        super(title);
        this.image = context.getResources().getDrawable(image);
    }

    @Override
    protected void setupView(View v) {
        super.setupView(v);
        ImageView iv = (ImageView) v.findViewById(android.R.id.icon);
        if (iv != null) {
            iv.setImageDrawable(image);
            iv.setContentDescription(title);
        }
    }

    @Override
    protected int getLayoutResourceId() {
        return R.layout.item_tripleheight;
    }
}
