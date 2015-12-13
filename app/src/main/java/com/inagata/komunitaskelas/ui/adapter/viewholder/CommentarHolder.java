package com.inagata.komunitaskelas.ui.adapter.viewholder;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.data.model.Commentar;

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
public class CommentarHolder extends BenihViewHolder<Commentar> {

    @Bind(R.id.image_profile_thread_commentar)
    ImageView profileImage;
    @Bind(R.id.tv_user_full_name_commentar)
    TextView fullName;
    @Bind(R.id.tv_date_activity_commentar)
    TextView dateCommentar;
    @Bind(R.id.tv_detail_thread_commentar)
    TextView detailCommentar;
    @Bind(R.id.button_vote_commentar)
    Button voteButtonCommentar;

    private Context mContext;

    public CommentarHolder(View itemView, BenihRecyclerAdapter.OnItemClickListener itemClickListener, BenihRecyclerAdapter.OnLongItemClickListener longItemClickListener, Context mContext) {
        super(itemView, itemClickListener, longItemClickListener);
        this.mContext = mContext;
    }

    @Override
    public void bind(Commentar commentar) {
        String getStatus = commentar.getStatus_voted();
        String getJumlah = commentar.getClass_jmlhvote();

        setImage(commentar.getUser_photos(), profileImage, R.drawable.ic_placeholder);
        fullName.setText(commentar.getClass_fullname());
        dateCommentar.setText(commentar.getClass_timepost());
        detailCommentar.setText(commentar.getClass_isicoment());

        voteButtonCommentar.setBackground(setButtonVote(getStatus));
        voteButtonCommentar.setText(getJumlah + " Voted");
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

    public Drawable setButtonVote(String status) {
        Drawable resource;
        if (status.equals("true")) {
            resource = mContext.getResources().getDrawable(R.drawable.button_border_fill);
            voteButtonCommentar.setTextColor(mContext.getResources().getColor(R.color.white));
        } else {
            resource = mContext.getResources().getDrawable(R.drawable.button_border);
            voteButtonCommentar.setTextColor(mContext.getResources().getColor(R.color.green_vote));
        }
        return resource;
    }
}
