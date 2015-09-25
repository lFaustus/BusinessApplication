package com.business.fragments;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.business.R;
import com.business.RootActivity;
import com.business.adapters.CustomRecyclerAdapter;
import com.business.model.AgencyProcess;
import com.business.model.BaseModel;
import com.business.volley.VolleyConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 24/09/2015.
 */
public class AgencyProcesses extends ControlPanel {
    //private RecyclerView mRecyclerView;
    private ArrayList<BaseModel> mArrayList = new ArrayList<BaseModel>();
   // private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
   public static String FRAGMENT_TAG;
    private static final String mRetrieveURL="http://192.168.1.36/christian-john/enduser/listprocesstemplatemobile.php";

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
            ((RootActivity)(getActivity())).onSectionAttached(FRAGMENT_TAG);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        super.mContentLabel.setText(FRAGMENT_TAG);
        //Log.e("Awstsu", mRetrieveURL);
        RequestQueue mRequestQueue = VolleyConnection.getInstance().getRequestQueue();
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.POST,mRetrieveURL, response -> {
            //Log.e("Aw", mRetrieveURL);
            try {
                JSONArray mInformation = response.getJSONArray("test");
                Log.e("mInformationCount",mInformation.length()+"");
                for(int i = 0; i<mInformation.length();i++)
                {

                    JSONObject mJsonObject = mInformation.getJSONObject(i);
                    AgencyProcess mAgencyProcess = new AgencyProcess();
                    mAgencyProcess.setId(mJsonObject.getString("id"));
                    mAgencyProcess.setName(mJsonObject.getString("name"));

                    mAgencyProcess.setAgency(mJsonObject.getString("agency"));
                    mAgencyProcess.setBranch(mJsonObject.getString("branch"));
                    mAgencyProcess.setAddress(mJsonObject.getString("address"));
                    mAgencyProcess.setCheck(mJsonObject.getString("check"));
                    mAgencyProcess.setUncheck(mJsonObject.getString("uncheck"));
                    mAgencyProcess.setDone(mJsonObject.getString("done"));
                    mAgencyProcess.setUndone(mJsonObject.getString("undone"));
                    mAgencyProcess.setWaiting(mJsonObject.getString("waiting"));
                    mAgencyProcess.setCount(mJsonObject.getString("productcount"));
                    mAgencyProcess.setRequirementCount(mJsonObject.getString("requirementtotal"));
                    mArrayList.add(mAgencyProcess);
                    Log.e("array size", mArrayList.size() + "");
                }
                mRecyclerView.setAdapter(new CustomRecyclerAdapter(getActivity(), mArrayList, R.layout.recyclerview_items_personal_agency_process, FRAGMENT_TAG));
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();

        });
        mRequestQueue.add(mJsonObjectRequest);

        /*mRecyclerView = (RecyclerView) LayoutInflater.from(getActivity()).inflate(R.layout.recyclerview,null);
        super.mContent.addView(mRecyclerView);
        if(getActivity().getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.HORIZONTAL);
        else
            mStaggeredGridLayoutManager = new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL);
        mStaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(mStaggeredGridLayoutManager);*/
        //Log.e("mArrayList sizeagency", mArrayList.size() + "");

    }
}
