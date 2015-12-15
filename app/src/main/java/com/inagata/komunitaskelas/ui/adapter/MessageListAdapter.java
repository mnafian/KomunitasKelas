package com.inagata.komunitaskelas.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.data.model.PrivateMessage;
import com.inagata.komunitaskelas.ui.adapter.viewholder.PrivateMessageHolder;

import id.zelory.benih.adapter.BenihRecyclerAdapter;

/**
 * Created on : December 13, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class MessageListAdapter extends BenihRecyclerAdapter<PrivateMessage, PrivateMessageHolder> {

    private Context mContext;

    public MessageListAdapter(Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected int getItemView(int viewType) {
        return R.layout.kom_list_item_message;
    }

    @Override
    public PrivateMessageHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new PrivateMessageHolder(getView(parent, viewType), itemClickListener, longItemClickListener, mContext);
    }
}
