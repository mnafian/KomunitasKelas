package com.inagata.komunitaskelas.ui.adapter.viewholder;

import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.data.model.SubjectClass;

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
public class SubjectHolder extends BenihViewHolder<SubjectClass> {

    @Bind(R.id.tv_tittle_thread)
    TextView tittleThread;
    @Bind(R.id.tv_total_comment)
    TextView totalComment;
    @Bind(R.id.tv_last_activity)
    TextView lastActivity;
    @Bind(R.id.button_pinned)
    Button buttonPinned;
    @Bind(R.id.lines_view)
    View viewLines;

    private Context mContext;

    public SubjectHolder(View itemView, BenihRecyclerAdapter.OnItemClickListener itemClickListener, BenihRecyclerAdapter.OnLongItemClickListener longItemClickListener, Context mContext) {
        super(itemView, itemClickListener, longItemClickListener);
        this.mContext = mContext;
    }

    @Override
    public void bind(SubjectClass subjectClass) {
        String jumlahComment = subjectClass.getClass_jmlhcoment() + " Comment";
        String statusPinned = subjectClass.getClass_pin();
        tittleThread.setText(subjectClass.getClass_title());
        totalComment.setText(jumlahComment);
        lastActivity.setText(subjectClass.getClass_time());

        if (statusPinned.equals("true")) {
            buttonPinned.setVisibility(View.VISIBLE);
            viewLines.setBackgroundColor(mContext.getResources().getColor(R.color.primary));
        } else {
            buttonPinned.setVisibility(View.INVISIBLE);
            viewLines.setBackgroundColor(mContext.getResources().getColor(R.color.gray));
        }
    }
}
