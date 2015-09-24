package com.business.fragments;

import android.os.Bundle;

import com.business.MainActivity;
import com.business.R;
import com.business.adapters.CustomRecyclerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 24/09/2015.
 */
public class AgencyProcesses extends ControlPanel {
    //private RecyclerView mRecyclerView;
    private ArrayList<String> mArrayList = new ArrayList<String>(Arrays.asList("1", "2", "3"));
   // private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
   public static String FRAGMENT_TAG;

    public static ControlPanel newInstance(String param1) {
        AgencyProcesses fragment = new AgencyProcesses();
        Bundle args = new Bundle();
        args.putString(FRAGMENT_KEY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            FRAGMENT_TAG = getArguments().getString(FRAGMENT_KEY);
            ((MainActivity)(getActivity())).onSectionAttached(FRAGMENT_TAG);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.mContentLabel.setText(FRAGMENT_TAG);
        /*mRecyclerView = (RecyclerView) LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview,null);
        super.mContent.addView(mRecyclerView);
        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        else
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);*/
        mRecyclerView.setAdapter(new CustomRecyclerAdapter(getActivity(), mArrayList, R.layout.recyclerview_items_personal_agency_process,FRAGMENT_TAG));
    }
}
