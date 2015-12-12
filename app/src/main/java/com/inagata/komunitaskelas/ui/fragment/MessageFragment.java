package com.inagata.komunitaskelas.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;

import com.inagata.komunitaskelas.R;

import butterknife.Bind;
import id.zelory.benih.fragment.BenihFragment;
import in.co.madhur.chatlib.MainActivity;

/**
 * Created on : December 06, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class MessageFragment extends BenihFragment {

    @Bind(R.id.card_sample) CardView cardSample;

    @Override
    protected int getFragmentView() {
        return R.layout.kom_fragment_message;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        cardSample.setOnClickListener(view -> doDetailMessage());
    }

    private void doDetailMessage() {
        Intent intent = new Intent(getActivity(), MainActivity.class);
        startActivity(intent);
    }
}
