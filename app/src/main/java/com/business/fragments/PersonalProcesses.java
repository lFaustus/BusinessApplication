package com.business.fragments;

import android.os.Bundle;

import com.business.R;
import com.business.RootActivity;
import com.business.adapters.CustomRecyclerAdapter;
import com.business.model.BaseModel;

import java.util.ArrayList;

/**
 * Created by User on 23/09/2015.
 */
public class PersonalProcesses extends ControlPanel {
    public static String FRAGMENT_TAG;
    //private RecyclerView mRecyclerView;
    private ArrayList<BaseModel> mArrayList = new ArrayList<BaseModel>();
    //private StaggeredGridLayoutManager mStaggeredGridLayoutManager;


    public static ControlPanel newInstance(String param1) {
        PersonalProcesses fragment = new PersonalProcesses();
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
            ((RootActivity)(getActivity())).onSectionAttached(FRAGMENT_TAG);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.mContentLabel.setText(FRAGMENT_TAG);
       /* mRecyclerView = (RecyclerView) LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview,null);
        super.mContent.addView(mRecyclerView);
        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        else
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);*/
        mRecyclerView.setAdapter(new CustomRecyclerAdapter(getActivity(), mArrayList,R.layout.recyclerview_items_personal_agency_process,FRAGMENT_TAG));


    }
}
