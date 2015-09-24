package com.business.fragments;

import android.os.Bundle;

import com.business.MainActivity;
import com.business.R;
import com.business.adapters.CustomRecyclerAdapter;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by User on 23/09/2015.
 */
public class ProcessesManager extends ControlPanel {

    //private RecyclerView mRecyclerView;
    private ArrayList<String> mArrayList = new ArrayList<String>(Arrays.asList("1","2","3"));
    //private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    public static String FRAGMENT_TAG;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     *
     * @return A new instance of fragment ControlPanel.
     */
    // TODO: Rename and change types and number of parameters
    public static ControlPanel newInstance(String param1) {
        ProcessesManager fragment = new ProcessesManager();
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
       /* mRecyclerView = (RecyclerView)LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview,null);
        super.mContent.addView(mRecyclerView);
        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        else
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);*/
        super.mRecyclerView.setAdapter(new CustomRecyclerAdapter(getActivity(), mArrayList,R.layout.recyclerview_items_manage_process,FRAGMENT_TAG));

    }
}
