package com.mylevel.app.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.mylevel.app.R;

import java.util.Objects;


public class ForgotPasswordFragment extends Fragment {

    private OnForgotPasswordInteraction mListener;
    private EditText edtEmail;

    public ForgotPasswordFragment() {
        // Required empty public constructor
    }


    public static ForgotPasswordFragment newInstance() {
        ForgotPasswordFragment fragment = new ForgotPasswordFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnForgotPasswordInteraction) {
            mListener = (OnForgotPasswordInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnForgotPasswordInteraction");
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
        View view = inflater.inflate(R.layout.fragment_forgot_password, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        edtEmail = view.findViewById(R.id.edtEmail);
        view.findViewById(R.id.btnSend).setOnClickListener(v-> onSend());
        view.findViewById(R.id.ivBack).setOnClickListener(v-> onBack());
    }

    private void onBack() {
        Objects.requireNonNull(getFragmentManager()).popBackStack();
    }

    private void onSend() {
        if(mListener!=null){
            mListener.onForgotPassword();
        }
    }





    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnForgotPasswordInteraction {
        void onForgotPassword();
    }
}
