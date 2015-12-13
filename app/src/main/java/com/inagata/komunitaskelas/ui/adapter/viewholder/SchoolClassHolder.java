package com.inagata.komunitaskelas.ui.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.data.model.SchoolClass;
import com.jakewharton.rxbinding.widget.RxTextView;

import butterknife.Bind;
import id.zelory.benih.adapter.BenihRecyclerAdapter;
import id.zelory.benih.adapter.viewholder.BenihViewHolder;
import timber.log.Timber;

/**
 * Created on : December 12, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class SchoolClassHolder extends BenihViewHolder<SchoolClass> {

    @Bind(R.id.tv_class_name)
    TextView className;
    @Bind(R.id.category_image)
    ImageView imageView;
    @Bind(R.id.tv_act_class)
    TextView classActivity;

    public SchoolClassHolder(View itemView, BenihRecyclerAdapter.OnItemClickListener itemClickListener, BenihRecyclerAdapter.OnLongItemClickListener longItemClickListener) {
        super(itemView, itemClickListener, longItemClickListener);
        RxTextView.textChanges(className)
                .subscribe(charSequence -> Timber.d(charSequence.toString()));
        RxTextView.textChanges(classActivity)
                .subscribe(charSequence -> Timber.d(charSequence.toString()));

    }

    @Override
    public void bind(SchoolClass schoolClass) {
        String classNameText = schoolClass.getClass_name() + " " + schoolClass.getClass_subject();
        String classType = schoolClass.getClass_type();
        Timber.d(classType);

        className.setText(classNameText);
        classActivity.setText(schoolClass.getClass_activity());
        imageView.setImageResource(setClassType(classType) != 0 ? setClassType(classType) : R.drawable.ic_mtk);
    }

    private int setClassType(String classType) {
        int resource = 0;
        if (classType != null) {
            if (classType.equals("mtk")) {
                resource = R.drawable.ic_mtk;
            } else if (classType.equals("fis")) {
                resource = R.drawable.ic_fisika;
            } else if (classType.equals("kim")) {
                resource = R.drawable.ic_kimia;
            } else if (classType.equals("bio")) {
                resource = R.drawable.ic_biologi;
            } else if (classType.equals("geo")) {
                resource = R.drawable.ic_geografi;
            } else if (classType.equals("aku")) {
                resource = R.drawable.ic_akutansi;
            } else if (classType.equals("sej")) {
                resource = R.drawable.ic_history;
            } else if (classType.equals("eko")) {
                resource = R.drawable.ic_economi;
            } else {
                resource = R.drawable.ic_sample;
            }
        }
        return resource;
    }
}
