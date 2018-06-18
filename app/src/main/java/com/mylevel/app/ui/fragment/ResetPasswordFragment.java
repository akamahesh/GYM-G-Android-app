package com.mylevel.app.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mylevel.app.R;

import java.util.Objects;


public class ResetPasswordFragment extends Fragment {

    private OnResetPasswordInteraction mListener;

    public ResetPasswordFragment() {
        // Required empty public constructor
    }


    public static ResetPasswordFragment newInstance() {
        ResetPasswordFragment fragment = new ResetPasswordFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnResetPasswordInteraction) {
            mListener = (OnResetPasswordInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnResetPasswordInteraction");
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
        View view = inflater.inflate(R.layout.fragment_reset_password, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view) {
        view.findViewById(R.id.ivBack).setOnClickListener(v->onBack());
    }

    private void onBack() {
        Objects.requireNonNull(getFragmentManager()).popBackStack();
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnResetPasswordInteraction {
        void onFragmentInteraction();
    }
}
