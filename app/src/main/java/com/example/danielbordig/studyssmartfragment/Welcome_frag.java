package com.example.danielbordig.studyssmartfragment;

import android.os.Bundle;
import android.os.Handler;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class Welcome_frag extends Fragment implements Runnable {

    Handler handler = new Handler();

    public Welcome_frag() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ImageView welcomeImage = new ImageView(getActivity());
        welcomeImage.setImageResource(R.mipmap.studysmartlogo);
        welcomeImage.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.push_up_in));

        if(savedInstanceState==null){
            handler.postDelayed(this, 1900);
        }
        return welcomeImage;
    }

    @Override
    public void run() {
        getFragmentManager().beginTransaction().replace(R.id.mainFrame, new HWC_frag()).commit();
    }

}
