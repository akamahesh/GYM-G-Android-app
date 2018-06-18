package com.mylevel.app.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;

import com.mylevel.app.R;


public class SignupFragment extends Fragment {

    private OnSignupInteractionListener mListener;
    private ImageView ivProfile;
    private EditText edtFirstName;
    private EditText edtLastName;
    private EditText edtEmail;
    private EditText edtPassword;
    private EditText edtConfirmPassword;
    private ImageView ivCheckBox;


    public SignupFragment() {
        // Required empty public constructor
    }


    public static SignupFragment newInstance() {
        SignupFragment fragment = new SignupFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_signup, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        ivProfile = view.findViewById(R.id.ivProfile);
        edtFirstName = view.findViewById(R.id.edtFirstName);
        edtLastName = view.findViewById(R.id.edtLastName);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtConfirmPassword = view.findViewById(R.id.edtConfirmPassword);
        ivCheckBox = view.findViewById(R.id.ivCheckBox);

        view.findViewById(R.id.ivInstagram).setOnClickListener(v-> onInstagram());
        view.findViewById(R.id.ivFacebook).setOnClickListener(v-> onFacebook());
        view.findViewById(R.id.ivGoogle).setOnClickListener(v-> onGoogle());
        view.findViewById(R.id.vTerms).setOnClickListener(v-> onTerms());
        view.findViewById(R.id.btnSignup).setOnClickListener(v->onSignup());
        view.findViewById(R.id.tvLogin).setOnClickListener(v->onLogin());
        ivProfile.setOnClickListener(v-> onProfile());
    }

    private void onLogin() {
        if (mListener != null) {
            mListener.gotoLogin();
        }
    }

    private void onSignup() {
        if (mListener != null) {
            mListener.onSignup();
        }
    }

    private void onTerms() {

    }

    private void onProfile() {

    }

    private void onFacebook() {
    }

    private void onGoogle() {
    }

    private void onInstagram() {
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSignupInteractionListener) {
            mListener = (OnSignupInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSignupInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnSignupInteractionListener {
        void onSignup();
        void gotoLogin();
    }
}
