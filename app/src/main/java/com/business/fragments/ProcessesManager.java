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
import com.business.model.ProcessManagerModel;
import com.business.volley.VolleyConnection;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by User on 23/09/2015.
 */
public class ProcessesManager extends ControlPanel {

    //private RecyclerView mRecyclerView;
    private ArrayList<BaseModel> mArrayList = new ArrayList<BaseModel>();
    //private StaggeredGridLayoutManager mStaggeredGridLayoutManager;
    public static String FRAGMENT_TAG;

    private static final String mRetrieveURL="http://192.168.1.36/christian-john/enduser/listprocessmobile.php";


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
                JSONArray mInformation = response.getJSONArray("manageprocess");
                Log.e("mInformationCount", mInformation.length() + "sd");
                for(int i = 0; i<mInformation.length();i++)
                {

                    JSONObject mJsonObject = mInformation.getJSONObject(i);
                    ProcessManagerModel mProcessManager = new ProcessManagerModel();
                    mProcessManager.setId(mJsonObject.getString("id"));
                    mProcessManager.setName(mJsonObject.getString("name"));
                    mProcessManager.setRecurrence(mJsonObject.getString("recurrence"));
                    mProcessManager.setNumber_Recurrence(mJsonObject.getString("number_recurrence"));
                    mProcessManager.setDateCreated(mJsonObject.getString("createdon"));
                    mProcessManager.setDateModified(mJsonObject.getString("datemodified"));

                    mArrayList.add(mProcessManager);
                    Log.e("array size", mArrayList.size() + "");
                }
                mRecyclerView.setAdapter(new CustomRecyclerAdapter(getActivity(), mArrayList, R.layout.recyclerview_items_manage_process, FRAGMENT_TAG));
            } catch (JSONException e) {

                e.printStackTrace();
            }
        }, error -> {
            error.printStackTrace();

        });
        mRequestQueue.add(mJsonObjectRequest);

    }
}
