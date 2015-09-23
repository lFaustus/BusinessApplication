package com.business.fragments;

import android.os.Bundle;

import com.business.R;
import com.business.adapters.CustomRecyclerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 23/09/2015.
 */
public class FileManager extends ControlPanel {
    private ArrayList<String> mArrayList = new ArrayList<String>(Arrays.asList("1", "2", "3"));

    public static ControlPanel newInstance(String param1) {
        FileManager fragment = new FileManager();
        Bundle args = new Bundle();
        args.putString(FRAGMENT_KEY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.mRecyclerView.setAdapter(new CustomRecyclerAdapter(getActivity(), mArrayList, R.layout.recyclerview_items_personal_agency_process, FRAGMENT_TAG));
    }
}
