package com.iksula.shoppingcart.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.iksula.shoppingcart.fragment.Fragment1;
import com.iksula.shoppingcart.fragment.Fragment2;

/**
 * Created by user on 20/7/16.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter
{

    private int tabCount;

    public ViewPagerAdapter(FragmentManager fm, int tabCount)
    {

        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position)
    {

        switch (position)
        {
            case 0:
                Fragment1 fragment1 = new Fragment1();
                return fragment1;
            case 1:
                Fragment2 fragment2 = new Fragment2();
                return fragment2;
        }
        return null;
    }

    @Override
    public int getCount()
    {

        return tabCount;
    }
}
