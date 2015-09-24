package com.business.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
 * Created by User on 25/09/2015.
 */
public class AgencyList extends ControlPanel {

    private ArrayList<BaseModel> mArrayList = new ArrayList<BaseModel>();
    // private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    public static String FRAGMENT_TAG;
    private static final String mRetrieveURL="http://192.168.1.36/christian-john/enduser/listagenciesmobile.php";

    public static AgencyList newInstance(String param1) {
        AgencyList fragment = new AgencyList();
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
        super.mContentHeader.setVisibility(View.GONE);

        RequestQueue mRequestQueue = VolleyConnection.getInstance().getRequestQueue();
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.POST,mRetrieveURL, response -> {
            //Log.e("Aw", mRetrieveURL);
            try {
                JSONArray mInformation = response.getJSONArray("agency");
                Log.e("mInformationCount", mInformation.length() + "");
                for(int i = 0; i<mInformation.length();i++)
                {

                    JSONObject mJsonObject = mInformation.getJSONObject(i);
                    AgencyProcess mAgencyProcess = new AgencyProcess();
                    //mAgencyProcess.setName(mJsonObject.getString("AgencyName"));

                    mAgencyProcess.setAgency(mJsonObject.getString("AgencyName"));
                    mAgencyProcess.setBranch(mJsonObject.getString("branch"));
                    mAgencyProcess.setAddress(mJsonObject.getString("address"));
                    /*mAgencyProcess.setCheck(mJsonObject.getString("check"));
                    mAgencyProcess.setUncheck(mJsonObject.getString("uncheck"));
                    mAgencyProcess.setDone(mJsonObject.getString("done"));
                    mAgencyProcess.setUndone(mJsonObject.getString("undone"));
                    mAgencyProcess.setWaiting(mJsonObject.getString("waiting"));
                    mAgencyProcess.setCount(mJsonObject.getString("productcount"));
                    mAgencyProcess.setRequirementCount(mJsonObject.getString("requirementtotal"));*/
                    mArrayList.add(mAgencyProcess);
                    Log.e("array size", mArrayList.size() + "");
                }
                mRecyclerView.setAdapter(new CustomRecyclerAdapter(getActivity(), mArrayList, R.layout.recyclerview_items_agency_list, FRAGMENT_TAG));
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();

        });
        mRequestQueue.add(mJsonObjectRequest);
    }
}
