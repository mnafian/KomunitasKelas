package com.inagata.komunitaskelas.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.data.model.Commentar;
import com.inagata.komunitaskelas.ui.adapter.viewholder.CommentarHolder;

import id.zelory.benih.adapter.BenihRecyclerAdapter;

/**
 * Created on : December 13, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class ThreadCommentarAdapter extends BenihRecyclerAdapter<Commentar, CommentarHolder> {

    private Context mContext;

    public ThreadCommentarAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int getItemView(int viewType) {
        return R.layout.kom_list_item_commentar;
    }

    @Override
    public CommentarHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommentarHolder(getView(parent, viewType), itemClickListener, longItemClickListener, mContext);
    }
}
