package com.inagata.komunitaskelas.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import id.zelory.benih.view.BenihImageView;

/**
 * Created on : December 13, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class KomunitasKelasImageView extends BenihImageView {
    public KomunitasKelasImageView(Context context) {
        super(context);
    }

    public KomunitasKelasImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public KomunitasKelasImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setImageUrl(String url, ImageView errorImageView, int resource) {
        Glide.with(getContext())
                .load(url)
                .placeholder(resource)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        errorImageView.setVisibility(VISIBLE);
                        setVisibility(INVISIBLE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        setVisibility(VISIBLE);
                        errorImageView.setVisibility(GONE);
                        return false;
                    }
                })
                .into(this);
    }
}
