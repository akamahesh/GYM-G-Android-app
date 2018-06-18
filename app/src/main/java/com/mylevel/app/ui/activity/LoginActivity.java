package com.mylevel.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.mylevel.app.R;
import com.mylevel.app.helper.FragmentUtil;
import com.mylevel.app.ui.fragment.EmailVerificationFragment;
import com.mylevel.app.ui.fragment.ForgotPasswordFragment;
import com.mylevel.app.ui.fragment.LoginFragment;
import com.mylevel.app.ui.fragment.ResetPasswordFragment;
import com.mylevel.app.ui.fragment.SignupFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnLoginInteractionListener, SignupFragment.OnSignupInteractionListener, ForgotPasswordFragment.OnForgotPasswordInteraction, EmailVerificationFragment.OnEmailVerificationInteraction {


    public static Intent getIntent(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FragmentUtil.changeFragment(getSupportFragmentManager(),LoginFragment.newInstance(),false,true);

    }


    /**
     * Callback function from @{@link LoginFragment}
     */
    @Override
    public void onLogin() {
        startActivity(HomeActivity.getIntent(this));
    }

    @Override
    public void gotoForgotPassword() {
        FragmentUtil.changeFragment(getSupportFragmentManager(),ForgotPasswordFragment.newInstance(),true,true);

    }

    @Override
    public void gotoSignup() {
        FragmentUtil.changeFragment(getSupportFragmentManager(),SignupFragment.newInstance(),true,true);

    }


    /**
     * Callback function from @{@link LoginFragment}
     */
    @Override
    public void onSignup() {
        startActivity(HomeActivity.getIntent(this));
    }

    @Override
    public void gotoLogin() {
        getSupportFragmentManager().popBackStack();
    }

    /**
     * Callback function from @{@link LoginFragment}
     */
    @Override
    public void onSkip() {
        startActivity(HomeActivity.getIntent(this));
    }

    @Override
    public void onForgotPassword() {
        FragmentUtil.changeFragment(getSupportFragmentManager(),EmailVerificationFragment.newInstance(),true,true);

    }

    @Override
    public void onVerificationCodeSubmission() {
        startActivity(HomeActivity.getIntent(this));
    }
}
