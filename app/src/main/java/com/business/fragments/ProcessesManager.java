package com.business.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.business.R;

/**
 * Created by User on 23/09/2015.
 */
public class ProcessesManager extends ControlPanel {



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.mContent.addView(LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview,null));
    }
}
