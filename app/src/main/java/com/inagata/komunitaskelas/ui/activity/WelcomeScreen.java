package com.inagata.komunitaskelas.ui.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.inagata.komunitaskelas.R;
import com.inagata.komunitaskelas.ui.adapter.WelcomePagerAdapter;
import com.inagata.komunitaskelas.ui.fragment.ImageWelcomeFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import id.zelory.benih.BenihActivity;
import id.zelory.benih.fragment.BenihFragment;

/**
 * Created on : December 06, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class WelcomeScreen extends BenihActivity implements ViewPager.OnPageChangeListener
{
    @Bind(R.id.pager) ViewPager viewPager;
    @Bind(R.id.iv_oval_2) ImageView ivOval2;
    @Bind(R.id.iv_oval_3) ImageView ivOval3;
    private List<BenihFragment> fragments;
    private int pos = 0;

    @Override
    protected int getActivityView()
    {
        return R.layout.kom_activity_welcome;
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState)
    {
        generateFragments();
        WelcomePagerAdapter adapter = new WelcomePagerAdapter(getSupportFragmentManager(), fragments);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(this);
    }

    private void generateFragments()
    {
        fragments = new ArrayList<>(3);
        fragments.add(ImageWelcomeFragment.getInstance(0));
        fragments.add(ImageWelcomeFragment.getInstance(1));
        fragments.add(ImageWelcomeFragment.getInstance(2));
        //TODO desain welcome
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {
        if (pos != position)
        {
            pos = position;
            resolveIcon();
        }
    }

    private void resolveIcon()
    {
        ivOval2.setImageResource(pos > 0 ? R.drawable.oval_blue : R.drawable.oval_white);
        ivOval3.setImageResource(pos > 1 ? R.drawable.oval_blue : R.drawable.oval_white);
    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
