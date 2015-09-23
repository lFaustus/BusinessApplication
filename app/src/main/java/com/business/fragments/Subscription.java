package com.business.fragments;

import android.os.Bundle;

/**
 * Created by User on 23/09/2015.
 */
public class Subscription extends ControlPanel {



    public static ControlPanel newInstance(String param1) {
        Subscription fragment = new Subscription();
        Bundle args = new Bundle();
        args.putString(FRAGMENT_KEY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }


}
