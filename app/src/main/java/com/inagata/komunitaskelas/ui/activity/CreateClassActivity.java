package com.inagata.komunitaskelas.ui.activity;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.inagata.komunitaskelas.R;

import butterknife.Bind;
import id.zelory.benih.BenihActivity;

/**
 * Created on : December 07, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class CreateClassActivity extends BenihActivity {

    @Bind(R.id.input_class) TextView inputClass;
    @Bind(R.id.input_topics_group) TextView inputTopics;

    @Bind(R.id.input_layout_class) TextInputLayout inputLayoutClass;
    @Bind(R.id.input_layout_topics_group) TextInputLayout inputLayoutGroups;

    @Bind(R.id.toolbar) Toolbar toolbar;

    @Bind(R.id.list_icon_class) LinearLayout listIconGroup;
    private TypedArray imgIcon;
    private RelativeLayout imageHolderLayout;

    @Override
    protected int getActivityView() {
        return R.layout.kom_activity_create_class;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState) {
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.activity_create_tittle);

        inputClass.addTextChangedListener(new InputWatcher(inputClass));
        inputTopics.addTextChangedListener(new InputWatcher(inputTopics));

        imageHolderLayout = (RelativeLayout) View.inflate(this, R.layout.kom_view_item_icon, null);
        ImageView image = (ImageView) imageHolderLayout.findViewById(R.id.image_icon_item);

        imgIcon = getResources().obtainTypedArray(R.array.random_imgs);
        int count = imgIcon.length();
        int[] ids = new int[count];
        for (int i = 0; i < ids.length; i++) {
            ids[i] = imgIcon.getResourceId(i, 0);
            ImageView imageItem = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(image.getWidth(), image.getHeight());
            imageItem.setLayoutParams(params);
            imageItem.setBackgroundResource(ids[i]);
            listIconGroup.addView(imageItem);
        }
    }

    private void submitForm() {
        if (!validateInputClass()) {
            return;
        }

        if (!validateInputGroups()) {
            return;
        }
    }

    private boolean validateInputClass() {
        if (inputClass.getText().toString().trim().isEmpty()) {
            inputLayoutClass.setError(getString(R.string.err_msg_name));
            requestFocus(inputClass);
            return false;
        } else {
            inputLayoutClass.setErrorEnabled(false);
        }
        return true;
    }

    private boolean validateInputGroups() {
        if (inputTopics.getText().toString().trim().isEmpty()) {
            inputLayoutGroups.setError(getString(R.string.err_msg_name));
            requestFocus(inputTopics);
            return false;
        } else {
            inputLayoutGroups.setErrorEnabled(false);
        }
        return true;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    private class InputWatcher implements TextWatcher {

        private View view;

        private InputWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.input_class:
                    validateInputClass();
                    break;
                case R.id.input_topics_group:
                    validateInputGroups();
                    break;
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_add_class, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_finish) {
            submitForm();
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
