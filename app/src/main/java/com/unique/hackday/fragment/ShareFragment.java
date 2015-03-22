package com.unique.hackday.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unique.hackday.R;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ShareFragment extends Fragment implements View.OnClickListener {



    public ShareFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View mainView = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.inject(this, mainView);
        init(mainView);
        return mainView;

    }


    @Override
    public void onStart() {
        super.onStart();

    }

    private void init(View view) {

    }


    @Override
    public void onClick(View v) {



    }

}
