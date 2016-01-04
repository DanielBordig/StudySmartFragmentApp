package com.example.danielbordig.studyssmartfragment;

import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.logging.LogRecord;

public class Welcome_frag extends Fragment implements Runnable {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    Fragment fragment_hwc = new HWC_frag();
    Handler handler = new Handler();

    public Welcome_frag() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView welcomeImage = new ImageView(getActivity());
        welcomeImage.setImageResource(R.mipmap.studysmartlogo);
        welcomeImage.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_in));

        return welcomeImage;
    }

    @Override
    public void run() {
        //getFragmentManager().beginTransaction().replace(R.id.mainFrame, fragment_hwc).commit();
    }

}
