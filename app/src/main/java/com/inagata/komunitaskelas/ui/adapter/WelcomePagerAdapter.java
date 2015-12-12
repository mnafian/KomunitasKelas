package com.inagata.komunitaskelas.ui.adapter;

import android.support.v4.app.FragmentManager;

import java.util.List;

import id.zelory.benih.adapter.BenihPagerAdapter;
import id.zelory.benih.fragment.BenihFragment;

/**
 * Created on : December 06, 2015
 * Author     : mnafian
 * Name       : M. Nafian
 * Email      : mnafian@icloud.com
 * GitHub     : https://github.com/mnafian
 * LinkedIn   : https://id.linkedin.com/in/mnafian
 */
public class WelcomePagerAdapter extends BenihPagerAdapter<BenihFragment>
{
    public WelcomePagerAdapter(FragmentManager fm, List<BenihFragment> benihFragments)
    {
        super(fm, benihFragments);
    }

    @Override
    public BenihFragment getItem(int position)
    {
        return fragments.get(position);
    }
}
