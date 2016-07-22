package com.iksula.shoppingcart.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iksula.shoppingcart.R;
import com.iksula.shoppingcart.adapter.ViewPagerImageAdapter;
import com.iksula.shoppingcart.util.CirclePageIndicator;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by user on 20/7/16.
 */
public class Fragment1 extends Fragment
{

    private ViewPager viewPager;

    private CirclePageIndicator pageIndicator;

    private String[] urls = {"http://globusstores.incomenterprise.com/media/mobileapp/homepageblocks/main_banner_02_1.png", "http://globusstores.incomenterprise.com/media/mobileapp/homepageblocks/small_banner_01_5.png", "http://globusstores.incomenterprise.com/media/mobileapp/homepageblocks/small_banner_01_4.png", "http://globusstores.incomenterprise.com/media/mobileapp/homepageblocks/small_banner_03_2.png"};

    //private String urls = "{\"Content\":[{\"Id\":15,\"Title\":\"ETHNIC WEAR\",\"ImageUrl\":\"http://globusstores.incomenterprise.com/media/mobileapp/homepageblocks/main_banner_02_1.png\",\"Type\":\"2\",\"BlockName\":\"Indian Ethnic Wear\",\"ElementId\":\"31242\"},{\"Id\":16,\"Title\":\"PARTY DRESS\",\"ImageUrl\":\"http://globusstores.incomenterprise.com/media/mobileapp/homepageblocks/small_banner_01_5.png\",\"Type\":\"1\",\"BlockName\":\"New Season Styles\",\"ElementId\":\"135\"},{\"Id\":17,\"Title\":\"Style Tips\",\"ImageUrl\":\"http://globusstores.incomenterprise.com/media/mobileapp/homepageblocks/small_banner_01_4.png\",\"Type\":\"1\",\"BlockName\":\"Get Inspired\",\"ElementId\":\"135\"},{\"Id\":18,\"Title\":\"IT'S CALLED STYLE\",\"ImageUrl\":\"http://globusstores.incomenterprise.com/media/mobileapp/homepageblocks/small_banner_03_2.png\",\"Type\":\"1\",\"BlockName\":\"Men's Collection\",\"ElementId\":\"129\"}]}";

    private int count = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {

        View view = inflater.inflate(R.layout.fragment1, null, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        pageIndicator = (CirclePageIndicator) view.findViewById(R.id.indicator);

        setViewPagerAdapter();

        return view;
    }

    private void setViewPagerAdapter()
    {

        try
        {
            ViewPagerImageAdapter adapter = new ViewPagerImageAdapter(getActivity(), urls);
            viewPager.setAdapter(adapter);

            pageIndicator.setViewPager(viewPager, 0);


            Timer timer = new Timer();
            timer.schedule(new TimerTask()
            {
                @Override
                public void run()
                {

                    getActivity().runOnUiThread(new Runnable()
                    {
                        @Override
                        public void run()
                        {

                            if (count <= urls.length)
                            {
                                viewPager.setCurrentItem(count);
                                count++;
                            }
                            else
                            {
                                count = 0;
                                viewPager.setCurrentItem(count);
                            }
                        }
                    });
                }
            }, 500, 1500);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
