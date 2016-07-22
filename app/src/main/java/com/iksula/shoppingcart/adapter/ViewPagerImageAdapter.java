package com.iksula.shoppingcart.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.iksula.shoppingcart.R;
import com.squareup.picasso.Picasso;

/**
 * Created by user on 20/7/16.
 */
public class ViewPagerImageAdapter extends PagerAdapter
{


    private Context context;

    private String[] url;

    private LayoutInflater layoutInflater;

    public ViewPagerImageAdapter(Context context, String[] url)
    {

        try
        {
            this.context = context;
            this.url = url;

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public int getCount()
    {

        return url.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {

        return view == ((LinearLayout) object);
    }

    @Override
    public void destroyItem(View container, int position, Object object)
    {

        ((ViewPager) container).removeView((View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, final int position)
    {

        View itemView = layoutInflater.inflate(R.layout.home_page_images, container, false);

        try
        {
            ImageView imageView = (ImageView) itemView.findViewById(R.id.homePageImage);
            Picasso.with(context).load(url[position]).into(imageView);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        container.addView(itemView);


        return itemView;
    }
}
