package com.business.fragments;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.business.R;
import com.business.RootActivity;
import com.business.adapters.CustomRecyclerAdapter;
import com.business.model.BaseModel;
import com.business.model.SubscriptionModel;
import com.business.volley.VolleyConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 23/09/2015.
 */
public class Subscription extends ControlPanel {
    private ArrayList<BaseModel> mArrayList = new ArrayList<BaseModel>();
    private static final String mRetrieveURL="http://192.168.1.36/christian-john/enduser/listsubscriptioneumobile.php";
    public static String FRAGMENT_TAG;


    public static ControlPanel newInstance(String param1) {
        Subscription fragment = new Subscription();
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

        RequestQueue mRequestQueue = VolleyConnection.getInstance().getRequestQueue();
        JsonObjectRequest mJsonObjectRequest = new JsonObjectRequest(Request.Method.POST,mRetrieveURL, response -> {

            try {
                JSONArray mInformation = response.getJSONArray("subscription");
                Log.e("mInformationCount", mInformation.length() + "sd");
                for(int i = 0; i<mInformation.length();i++)
                {

                    JSONObject mJsonObject = mInformation.getJSONObject(i);
                    SubscriptionModel mSubscriptionModel = new SubscriptionModel();
                    mSubscriptionModel.setPlanDescription(mJsonObject.getString("plandescription"));
                    mSubscriptionModel.setNumberMonthsYear(mJsonObject.getString("number_of_mo_year"));
                    mSubscriptionModel.setRate(mJsonObject.getString("rate"));
                    mSubscriptionModel.setTotalAmount(mJsonObject.getString("totalamount"));
                    mSubscriptionModel.setPaypalAccount(mJsonObject.getString("paypalaccount"));
                    mSubscriptionModel.setStartDate(mJsonObject.getString("startdate"));
                    mSubscriptionModel.setEndDate(mJsonObject.getString("enddate"));

                    mArrayList.add(mSubscriptionModel);
                    Log.e("array size", mArrayList.size() + "");
                }
                mRecyclerView.setAdapter(new CustomRecyclerAdapter(getActivity(), mArrayList, R.layout.subscription, FRAGMENT_TAG));
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();

        });
        mRequestQueue.add(mJsonObjectRequest);

    }



}
