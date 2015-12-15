package com.inagata.komunitaskelas.ui.adapter.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.data.model.PrivateMessage;

import butterknife.Bind;
import id.zelory.benih.adapter.BenihRecyclerAdapter;
import id.zelory.benih.adapter.viewholder.BenihViewHolder;

/**
 * Created on : December 13, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class PrivateMessageHolder extends BenihViewHolder<PrivateMessage> {

    @Bind(R.id.tv_chat_profile_name)
    TextView chatName;
    @Bind(R.id.tv_last_activity)
    TextView lastActvity;
    @Bind(R.id.tv_last_message)
    TextView lastMessage;
    @Bind(R.id.image_profile_chat)
    ImageView imageView;

    private Context mContext;

    public PrivateMessageHolder(View itemView, BenihRecyclerAdapter.OnItemClickListener itemClickListener, BenihRecyclerAdapter.OnLongItemClickListener longItemClickListener, Context mContext) {
        super(itemView, itemClickListener, longItemClickListener);
        this.mContext = mContext;
    }

    @Override
    public void bind(PrivateMessage privateMessage) {
        chatName.setText(privateMessage.getClass_fullname());
        lastActvity.setText(privateMessage.getClass_time());
        lastMessage.setText(privateMessage.getClass_message());

        setImage(privateMessage.getNormal(), imageView, R.drawable.ic_placeholder);
    }

    public void setImage(String url, ImageView targetImageView, int resource) {
        Glide.with(mContext)
                .load(url)
                .asBitmap()
                .placeholder(resource)
                .into(new BitmapImageViewTarget(targetImageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable =
                                RoundedBitmapDrawableFactory.create(mContext.getResources(), resource);
                        circularBitmapDrawable.setCircular(true);
                        targetImageView.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }
}
