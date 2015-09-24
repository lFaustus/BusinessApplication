package com.business.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
import com.business.volley.VolleyConnection;

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
        RequestQueue mRequestQueue = VolleyConnection.getInstance().getRequestQueue();

        mLoginButton.setOnClickListener(v -> {
            StringRequest mLoginRequest = new StringRequest(Request.Method.POST, mLoginURL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.e("response", response.toString());
                    getFragmentManager().beginTransaction()
                            .replace(R.id.rootview, HomePage.newInstance("Home"))
                            .commit();
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
