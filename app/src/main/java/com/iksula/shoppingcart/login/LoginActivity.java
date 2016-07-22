package com.iksula.shoppingcart.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.iksula.shoppingcart.R;
import com.iksula.shoppingcart.home.HomeActivity;

/**
 * Created by user on 20/7/16.
 */
public class LoginActivity extends Activity
{

    private TextInputLayout usernameInputLayout;

    private TextInputLayout passwordInputLayout;

    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        initView();
    }

    private void initView()
    {

        usernameInputLayout = (TextInputLayout) findViewById(R.id.usernameInputLayout);
        passwordInputLayout = (TextInputLayout) findViewById(R.id.passwordInputLayout);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        startAnimations();
    }

    private void startAnimations()
    {


        Animation anim = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim.reset();
        anim.setDuration(1000);
        usernameInputLayout.clearAnimation();
        usernameInputLayout.startAnimation(anim);

        final Animation anim1 = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim1.reset();
        anim1.setDuration(2000);
        passwordInputLayout.clearAnimation();
        passwordInputLayout.setVisibility(View.VISIBLE);
        passwordInputLayout.startAnimation(anim1);

        final Animation anim2 = AnimationUtils.loadAnimation(this, R.anim.translate);
        anim2.reset();
        anim2.setDuration(3000);
        btnLogin.clearAnimation();
        btnLogin.setVisibility(View.VISIBLE);
        btnLogin.startAnimation(anim2);


    }

    public void login(View v)
    {

        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}
