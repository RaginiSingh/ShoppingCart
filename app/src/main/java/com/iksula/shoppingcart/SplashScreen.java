package com.iksula.shoppingcart;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.iksula.shoppingcart.login.LoginActivity;

/**
 * Created by user on 20/7/16.
 */
public class SplashScreen extends BaseActivity
{


    private Handler handler = new Handler(new Handler.Callback()
    {
        @Override
        public boolean handleMessage(Message msg)
        {

            if (msg.what == 0)
            {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }

            return false;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);

        startAnimations();
        startThread();

    }

    private void startAnimations()
    {

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l = (RelativeLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        TextView iv = (TextView) findViewById(R.id.textview);
        iv.clearAnimation();
        iv.startAnimation(anim);

      /*  anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        LinearLayout l2 = (LinearLayout) findViewById(R.id.linear2);
        l2.setVisibility(View.VISIBLE);
        l2.clearAnimation();
        l2.startAnimation(anim);*/
    }

    private void startThread()
    {

        Thread thread = new Thread(new Runnable()
        {
            @Override
            public void run()
            {

                synchronized (this)
                {
                    try
                    {
                        wait(3000);
                    }
                    catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                handler.sendEmptyMessage(0);

            }
        });

        thread.start();

    }
}
