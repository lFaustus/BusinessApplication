package com.business.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.business.R;
import com.business.customviews.circularimageview.CircleImageView;
import com.business.interfaces.FragmentChangeListener;


public class ControlPanel extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    protected static String FRAGMENT_KEY = "ControlPanel";

    // TODO: Rename and change types of parameters


    private FragmentChangeListener mListener;

    protected CircleImageView mContentIcon;

    protected TextView mContentLabel;

    protected FrameLayout mContent;

    protected RecyclerView mRecyclerView;

    private StaggeredGridLayoutManager mStaggeredGridLayoutManager;



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
        ControlPanel fragment = new ControlPanel();
        Bundle args = new Bundle();
        args.putString(FRAGMENT_KEY, param1);
        fragment.setArguments(args);
        return fragment;
    }

    public ControlPanel() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.content, container, false);
        mContentIcon = (CircleImageView)v.findViewById(R.id.content_icon);
        mContentLabel = (TextView)v.findViewById(R.id.content_label);
        //mContentLabel.setTypeface(((MainActivity)getActivity()).PlayRegularFont());
        mContent = (FrameLayout)v.findViewById(R.id.content);
        return v;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mRecyclerView = (RecyclerView)LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview,null);
        mContent.addView(mRecyclerView);
        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        else
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.OnFragmentChange(null);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
           // mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        if(mContent.getChildCount() != 0)
            mContent.removeAllViews();
        mListener = null;

    }


}
