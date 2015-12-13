package com.inagata.komunitaskelas.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.ui.activity.LoginActivity;

import butterknife.Bind;
import id.zelory.benih.fragment.BenihFragment;

/**
 * Created on : December 06, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class ImageWelcomeFragment extends BenihFragment
{
    @Bind(R.id.title) TextView title;
    @Bind(R.id.description) TextView description;
    @Bind(R.id.image) ImageView image;
    @Bind(R.id.tv_btn_done) TextView done;
    private int position;

    public static ImageWelcomeFragment getInstance(int position)
    {
        ImageWelcomeFragment fragment = new ImageWelcomeFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    protected int getFragmentView()
    {
        return R.layout.kom_fragment_image_welcome;
    }

    @Override
    protected void onViewReady(@Nullable Bundle savedInstanceState)
    {
        position = getArguments().getInt("position", 0);
        setContent();
        done.setOnClickListener(this::submit);
    }

    private void submit(View view)
    {
        Intent intent = new Intent(getActivity(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        getActivity().finish();
    }

    private void setContent()
    {
        switch (position)
        {
            case 0:
                title.setText(R.string.welcome);
                description.setText(R.string.set_welcome_message_1);
                image.setImageResource(R.drawable.welcome_1);
                done.setVisibility(View.INVISIBLE);
                break;
            case 1:
                title.setText(R.string.welcome_2);
                description.setText(R.string.set_welcome_message_2);
                image.setImageResource(R.drawable.welcome_2);
                done.setVisibility(View.INVISIBLE);
                break;
            case 2:
                title.setText(R.string.welcome_3);
                description.setText(R.string.set_welcome_message_3);
                image.setImageResource(R.drawable.welcome_3);
                done.setVisibility(View.VISIBLE);
                break;
        }
    }
}
