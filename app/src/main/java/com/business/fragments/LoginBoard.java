package com.business.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.business.R;
import com.business.RootActivity;
import com.business.model.EndUser;
import com.business.volley.VolleyConnection;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 25/09/2015.
 */
public class LoginBoard extends Fragment{
    private EditText mUsername;
    private EditText mPassword;
    private Button mLoginButton;
    private String mLoginURL="http://192.168.1.36/christian-john/enduser/loginmobile.php";
    private static String FRAGMENT_KEY ="LoginBoard";
    private static String FRAGMENT_TAG;


    public static LoginBoard newInstance(String param1) {
        LoginBoard fragment = new LoginBoard();
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
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_login_page,container,false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mUsername = (EditText)getView().findViewById(R.id.username);
        mPassword = (EditText)getView().findViewById(R.id.password);
        mLoginButton = (Button)getView().findViewById(R.id.loginbutton);

        ((RootActivity)getActivity()).setCookie(mUsername.getText().toString(),mPassword.getText().toString());

        RequestQueue mRequestQueue = VolleyConnection.getInstance().getRequestQueue();
        mLoginButton.setOnClickListener(v -> {
            StringRequest mLoginRequest = new StringRequest(Request.Method.POST, mLoginURL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {

                    StringBuilder sb = new StringBuilder(response);
                    sb.setCharAt(0,' ');
                    sb.setCharAt(sb.length()-1,' ');
                    Log.e("response", sb.toString());
                    try {

                        JSONObject mUserData = new JSONObject(sb.toString());
                        EndUser mEndUser = new EndUser();
                        mEndUser.setProfilePic(mUserData.get("imgurl").toString());
                        mEndUser.setAccountStatus(mUserData.get("status").toString());
                        mEndUser.setAddress(mUserData.get("address").toString());
                        mEndUser.setContactNumber(mUserData.get("contactno").toString());
                        mEndUser.setEmailAddress(mUserData.get("email").toString());
                        mEndUser.setUsername(mUserData.get("username").toString().toCharArray());
                        mEndUser.setPassword(mUserData.get("password").toString().toCharArray());
                        mEndUser.setName(mUserData.get("firstname").toString());
                        mEndUser.setLastName(mUserData.get("lastname").toString());
                        mEndUser.setMiddleName(mUserData.get("middlename").toString());
                        mEndUser.setBirthDay(mUserData.get("bdate").toString());

                        getFragmentManager().beginTransaction()
                                .replace(R.id.rootview, HomePage.newInstance("Home",mEndUser))
                                .commit();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }

            }, error -> {
                error.printStackTrace();
            }){
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String,String> params = new HashMap<String,String>();
                    params.put("user",mUsername.getText().toString());
                    params.put("pass",mPassword.getText().toString());
                    return params;
                }
            };
            mRequestQueue.add(mLoginRequest);
        });
    }
}
