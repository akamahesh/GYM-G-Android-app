package com.mylevel.app.ui.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.mylevel.app.R;


public class LoginFragment extends Fragment {

    private OnLoginInteractionListener mListener;
    private TextView tvLang;
    private EditText edtEmail;
    private EditText edtPassword;
    private TextView tvForgotPassword;
    private Button btnLogin;
    private Spinner spinnerLang;
    private String[] languages={"English","Arabic"};


    public LoginFragment() {
        // Required empty public constructor
    }


    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginInteractionListener) {
            mListener = (OnLoginInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnLoginInteractionListener");
        }
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
        View view =  inflater.inflate(R.layout.fragment_login, container, false);

        initViews(view);
        spinnerLang.setOnItemSelectedListener(onItemSelectedListener);

        //Creating the ArrayAdapter instance having the bank name list
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,languages);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerLang.setAdapter(arrayAdapter);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            tvLang.setText(languages[position]);
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {

        }
    };


    private void initViews(View view) {
        tvLang = view.findViewById(R.id.tvLang);
        spinnerLang = view.findViewById(R.id.spinnerLang);
        edtEmail = view.findViewById(R.id.edtEmail);
        edtPassword = view.findViewById(R.id.edtPassword);

        view.findViewById(R.id.btnSkip).setOnClickListener(v-> onSkip());
        view.findViewById(R.id.tvLang).setOnClickListener(v-> onLanguage());
        view.findViewById(R.id.btnLogin).setOnClickListener(v -> onLogin());
        view.findViewById(R.id.tvForgotPassword).setOnClickListener(v-> onForgotPassword());
        view.findViewById(R.id.ivInstagram).setOnClickListener(v-> onInstagram());
        view.findViewById(R.id.ivFacebook).setOnClickListener(v-> onFacebook());
        view.findViewById(R.id.ivGoogle).setOnClickListener(v-> onGoogle());
        view.findViewById(R.id.tvSignup).setOnClickListener(v-> onSignup());
    }

    private void onLanguage() {
        spinnerLang.performClick();
    }

    /**
     * Sign up
     */
    private void onSignup() {
        if (mListener != null) {
            mListener.onSignup();
        }
    }

    /**
     * Facebook Login
     */
    private void onFacebook() {
    }

    /**
     * Google Login
     */
    private void onGoogle() {
    }

    /**
     * Instagram Login
     */
    private void onInstagram() {
    }

    /**
     * Instagram Login
     */
    private void onForgotPassword() {
        if (mListener != null) {
            mListener.onForgotPassord();
        }
    }

    /**
     * Email Login
     */
    private void onLogin() {
        if (mListener != null) {
            mListener.onLogin();
        }
    }

    /**
     * Skip
     */
    private void onSkip() {
        if (mListener != null) {
            mListener.onSkip();
        }
    }




    public interface OnLoginInteractionListener {
        void onLogin();
        void onForgotPassord();
        void onSignup();
        void onSkip();
    }
}
