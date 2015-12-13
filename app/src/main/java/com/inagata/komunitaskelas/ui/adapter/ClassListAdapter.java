package com.inagata.komunitaskelas.ui.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.data.model.SchoolClass;
import com.inagata.komunitaskelas.ui.adapter.viewholder.SchoolClassHolder;

import id.zelory.benih.adapter.BenihRecyclerAdapter;

/**
 * Created on : December 12, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class ClassListAdapter extends BenihRecyclerAdapter<SchoolClass, SchoolClassHolder> {

    public ClassListAdapter(Context context) {
        super(context);
    }

    @Override
    protected int getItemView(int viewType) {
        return R.layout.kom_list_item_class;
    }

    @Override
    public SchoolClassHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new SchoolClassHolder(getView(parent, viewType), itemClickListener, longItemClickListener);
    }
}
