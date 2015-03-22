package com.unique.hackday.fragment;

import android.app.Activity;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.unique.hackday.R;
import com.unique.hackday.utils.DebugLog;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class MainFragment extends Fragment implements View.OnClickListener {


    @InjectView(R.id.main_text_view_head)
    TextView headText;
    @InjectView(R.id.main_text_view_up)
    TextView upText;
    @InjectView(R.id.main_text_view_down)
    TextView downText;

    @InjectView(R.id.main_body_ll)
    LinearLayout linearLayout;

    public MainFragment() {
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
        headText.setOnClickListener(this);
        upText.setOnClickListener(this);
        downText.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        cleanColor();
        switch (v.getId()) {
            case R.id.item_head:
                break;
            case R.id.main_text_view_head:
                // do something
                getActivity().getLayoutInflater().inflate(R.layout.,null);
                headText.setBackgroundColor(Color.parseColor("#057464"));
                break;
            case R.id.main_text_view_up:
                // do something when
                getActivity().getLayoutInflater().inflate(R.layout.,null);
                upText.setBackgroundColor(Color.parseColor("#057464"));
                break;
            case R.id.main_text_view_down:
                getActivity().getLayoutInflater().inflate(R.layout.,null);
                //chose
                downText.setBackgroundColor(Color.parseColor("#057464"));
                break;
            default:
                break;
        }

    }

    public void cleanColor() {

        headText.setBackgroundColor(Color.parseColor("#089d87"));
        upText.setBackgroundColor(Color.parseColor("#089d87"));
        downText.setBackgroundColor(Color.parseColor("#089d87"));

    }
}
